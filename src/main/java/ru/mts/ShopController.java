package ru.mts;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/shop")
@RequiredArgsConstructor
@Slf4j
public class ShopController {

    @Autowired
    private final ShopProdService shopProdService;

    @PostMapping()
    public void postShopping(@RequestBody List<OrderProduct> orderProduct) throws InterruptedException {
        shopProdService.timeShopping(orderProduct);
    }

//    @PostMapping()
//    public void postShopping(@RequestBody Map<String, Integer> orderProduct) throws InterruptedException {
//        RestTemplate restTemplate = new RestTemplate();
//        String fooResourceUrl = "http://localhost:8080/api/shop";
//        HttpEntity<Map<String, Integer>> product = new HttpEntity<>(orderProduct);
//        OrderProduct foo = restTemplate.postForObject(fooResourceUrl, product, OrderProduct.class);
//        shopProdService.timeShopping(orderProduct);
//    }
}
