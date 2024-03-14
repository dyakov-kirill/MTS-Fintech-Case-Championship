package ru.mts.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mts.dto.DeliveryDto;
import ru.mts.entities.Delivery;
import ru.mts.repositories.DeliveryRepository;

@Service
@Slf4j
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public void save(DeliveryDto dto) {
        log.info("saving log of Delivery");

        deliveryRepository.save(new Delivery()
                .setOrderId(dto.getOrderId())
                .setDuration(dto.getDuration())
                .setCourierType(dto.getCourierType()));
    }
}
