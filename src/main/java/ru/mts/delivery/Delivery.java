package ru.mts.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.Order;

@Component
public class Delivery {
    private Order order;

    private final DeliveryManager deliveryManager;

    public Delivery(DeliveryManager deliveryManager) {
        this.deliveryManager = deliveryManager;
    }

    public void startDelivery() {
        deliveryManager.manageDelivery(order);
    }
}
