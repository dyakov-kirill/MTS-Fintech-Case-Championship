package ru.mts.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Entity
public class Order implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(Order.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private Map<ProductType, Integer> products; // type of products ordered and count of the certain product

    private LocalDateTime creationTime; // time of creation of the order

    private OrderType orderType; // type of order either by courier or at cash

    private Cities city; // city to carry the order to

    public Order(Map<ProductType, Integer> productsAndCount, LocalDateTime time, OrderType type, Cities city) {
        this.products = productsAndCount;
        this.creationTime = time;
        this.orderType = type;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    /**
     * Returns the type of products ordered and count of the certain product
     */
    public Map<ProductType, Integer> getProducts() {
        return products;
    }

    /**
     * Returns time of creation of the order
     */
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * Returns type of order either by courier or at cash
     */
    public OrderType getOrderType() {
        return orderType;
    }

    /**
     * Returns city to carry the order to
     */
    public Cities getCity() {
        return city;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String result = builder.append("Order[id = ").append(id).append(", ")
                .append("products=[").append(products.toString()).append("], ")
                .append("creationTime=").append(creationTime.format(formatter)).append(", ")
                .append("orderType=").append(orderType.toString()).append(", ")
                .append("city=").append(city.toString()).append("]")
                .toString();
        logger.info(result);
        return result;
    }
}
