package ru.mts.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mts.Order;
import ru.mts.delivery.courier.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@RestController
@RequestMapping("/api/shop")
@RequiredArgsConstructor
public class DeliveryManager {
    Map<Couriers, Integer> couriersAmount;

    @Autowired
    public DeliveryManager(Map<Couriers, Integer> couriersAmount) {
        this.couriersAmount = couriersAmount;
    }

    public void manageDelivery(Order order) {
        int amount = orderAmount(order);
        if (amount > 20) {
            throw new RuntimeException("Слишком большое количество заказов:" + amount);
        } else if (amount > 10) {
            if (couriersAmount.get(Couriers.CAR) > 0) {
                Car car = new Car();
                car.deliver();
            }
        } else if (amount > 5) {
            if (couriersAmount.get(Couriers.BIKE) > 0) {
                Bike bike = new Bike();
                bike.deliver();
            }
        } else {
            if (couriersAmount.get(Couriers.PEDESTRIAN) > 0) {
                Pedestrian pedestrian = new Pedestrian();
                pedestrian.deliver();
            }
        }
    }

    private int orderAmount(Order order) {
        AtomicInteger result = new AtomicInteger();
        order.getProducts().forEach(
                (product, integer) -> result.addAndGet(integer)
        );

        return result.get();
    }
}
