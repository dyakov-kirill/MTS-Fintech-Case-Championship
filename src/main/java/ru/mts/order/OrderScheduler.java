package ru.mts.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class OrderScheduler {
    static final private Logger logger = LoggerFactory.getLogger(OrderScheduler.class);

    private final static int POSITION_COUNT = 3; // max count of positions ordered,
    // depends on type of realization (== 6 if is multithreading)

    private static final Random random = new Random();

    private ProductType generateProductType(List<ProductType> types) {
        if (types.isEmpty())
            return null;
        ProductType type = types.get(random.nextInt(types.size()));
        types.remove(type);
        return type;
    }

    /**
     * Generates a random order
     * */
    private Order generateOrder() {
        // generate map
        int productsLeft = random.nextInt(POSITION_COUNT);
        Map<ProductType, Integer> products = new HashMap<>(productsLeft);
        List<ProductType> productTypes = new ArrayList<>(Arrays.asList(ProductType.values()));
        int countOfCertainProductInOrder;

        for (int i = 0; i < productsLeft; i++) {
            countOfCertainProductInOrder = random.nextInt(productsLeft);
            if (productsLeft < countOfCertainProductInOrder) {
//                if (productsLeft > 0) {
//                    products.put(generateProductType(productTypes), productsLeft);
//                }
                break;
            }
            productsLeft -= countOfCertainProductInOrder;

            products.put(generateProductType(productTypes), countOfCertainProductInOrder);
        }

        // generate order time
        OrderType orderType = OrderType.values()[random.nextInt(OrderType.values().length)];

        // generate city
        Cities city = Cities.values()[random.nextInt(Cities.values().length)];
        return new Order(products, LocalDateTime.now(), orderType, city);
    }

    private static final ThreadPoolTaskExecutor exec = new ThreadPoolTaskExecutor();

    static {
        exec.setCorePoolSize(1);
        exec.setMaxPoolSize(1);
        exec.setQueueCapacity(10);
        exec.setThreadNamePrefix("first-");
        exec.initialize();
    }

    private static final ConcurrentLinkedQueue<Order> orders = new ConcurrentLinkedQueue<>();

    private static final String historyResourceUrl = "http://localhost:8080/history-rest/orders";
    private static final String kitchenResourceUrl = "http://localhost:8080/kitchen-rest/orders";
    private static final String deliveryResourceUrl = "http://localhost:8080/delivery-rest/orders";
    private static final RestTemplate restTemplate = new RestTemplate();


    @Async("schedulePool1")
    @Scheduled(fixedDelay = 20000)
    public void placeAnOrder() {
        Order order = generateOrder();
        orders.add(order);
        // post to history
        HttpEntity<Order> requestForHistory = new HttpEntity<>(order);
        restTemplate.postForObject(historyResourceUrl, requestForHistory, Order.class);

        // post an order to kitchen
        HttpEntity<Order> requestForKitchen = new HttpEntity<>(order);
        restTemplate.postForObject(historyResourceUrl, requestForKitchen, Order.class);

        // get a response from the kitchen
        ResponseEntity<String> response
                = restTemplate.getForEntity(kitchenResourceUrl + "/" + order.getId(), String.class);
//        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        orders.remove(order);

        // post an order to delivery
        HttpEntity<Order> requestForDelivery = new HttpEntity<>(order);
        restTemplate.postForObject(deliveryResourceUrl, requestForDelivery, Order.class);

    }


}
