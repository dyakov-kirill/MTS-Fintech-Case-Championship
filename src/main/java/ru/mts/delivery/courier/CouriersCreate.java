package ru.mts.delivery.courier;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.mts.delivery.courier.AbstractCourier;
import ru.mts.delivery.courier.Couriers;

import java.util.HashMap;
import java.util.Map;

@Component
public class CouriersCreate {

    @Bean
    public Map<Couriers, Integer> createCouriers() {
        Map<Couriers, Integer> map = new HashMap<>();
        map.put(Couriers.CAR, 2);
        map.put(Couriers.BIKE, 3);
        map.put(Couriers.PEDESTRIAN, 5);

        return map;
    }


}
