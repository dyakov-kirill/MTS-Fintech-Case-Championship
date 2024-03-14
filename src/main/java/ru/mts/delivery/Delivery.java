package ru.mts.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mts.Order;
import ru.mts.Product;

import java.util.List;

@RestController
@RequestMapping("/api/shop")
@RequiredArgsConstructor
public class Delivery {

    private final DeliveryManager deliveryManager;

    public Delivery(DeliveryManager deliveryManager) {
        this.deliveryManager = deliveryManager;
    }

    @PostMapping()
    public void startDelivery(@RequestBody List<Product> orderProduct) {
        deliveryManager.manageDelivery(orderProduct);
    }
}
