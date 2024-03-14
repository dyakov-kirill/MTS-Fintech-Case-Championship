package ru.mts;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class ShopProdService {

    public void timeShopping(List<OrderProduct> productList) throws InterruptedException {
        for (OrderProduct orderProduct : productList) {
            switch (orderProduct.getNameProduct()) {
                case ("Тесто"):
                    log.info("Закупка товара: {}...",orderProduct.getNameProduct());
                    Thread.sleep((long) 1000 * orderProduct.getCntProduct());
                    break;
                case ("Мясо"):
                    log.info("Закупка товара: {}...",orderProduct.getNameProduct());
                    Thread.sleep((long) 2 * 1000 * orderProduct.getCntProduct());
                    break;
                case ("Капуста"):
                    log.info("Закупка товара: {}...",orderProduct.getNameProduct());
                    Thread.sleep((long) 2 * 1000 * orderProduct.getCntProduct());
                    break;
                case ("Рыба"):
                    log.info("Закупка товара: {}...",orderProduct.getNameProduct());
                    Thread.sleep((long) 3 * 1000 * orderProduct.getCntProduct());
                    break;
                case ("Ягоды"):
                    log.info("Закупка товара: {}...",orderProduct.getNameProduct());
                    Thread.sleep((long) 5 * 1000 * orderProduct.getCntProduct());
                    break;
                case ("Листовой чай"):
                    log.info("Закупка товара: {}...",orderProduct.getNameProduct());
                    Thread.sleep((long) 2 * 1000 * orderProduct.getCntProduct());
                    break;
                case ("Зерна кофе"):
                    log.info("Закупка товара: {}...",orderProduct.getNameProduct());
                    Thread.sleep((long) 2 * 1000 * orderProduct.getCntProduct());
                    break;
            }
        }
    }

}
