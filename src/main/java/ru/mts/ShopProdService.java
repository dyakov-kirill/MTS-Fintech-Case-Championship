package ru.mts;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
@Slf4j
public class ShopProdService {

    public void timeShopping(Map<String, Integer> productList) throws InterruptedException {
        for (String order: productList.keySet()) {
            switch (order) {
                case ("Тесто"):
                    log.info("Закупка товара: {}...",order);
                    Thread.sleep((long) 1000 * productList.get(order));
                    break;
                case ("Мясо"):
                    log.info("Закупка товара: {}...",order);
                    Thread.sleep((long) 2 * 1000 * productList.get(order));
                    break;
                case ("Капуста"):
                    log.info("Закупка товара: {}...",order);
                    Thread.sleep((long) 2 * 1000 * productList.get(order));
                    break;
                case ("Рыба"):
                    log.info("Закупка товара: {}...",order);
                    Thread.sleep((long) 3 * 1000 * productList.get(order));
                    break;
                case ("Ягоды"):
                    log.info("Закупка товара: {}...",order);
                    Thread.sleep((long) 2 * 1000 * productList.get(order));
                    break;
                case ("Листовой чай"):
                    log.info("Закупка товара: {}...",order);
                    Thread.sleep((long) 2 * 1000 * productList.get(order));
                    break;
                case ("Зерна кофе"):
                    log.info("Закупка товара: {}...",order);
                    Thread.sleep((long) 2 * 1000 * productList.get(order));
                    break;
            }
        }
    }

}
