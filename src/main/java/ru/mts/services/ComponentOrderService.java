package ru.mts.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mts.dto.ComponentOrderDto;
import ru.mts.entities.ComponentOrder;
import ru.mts.repositories.ComponentOrderRepository;

@Service
@Slf4j
public class ComponentOrderService {

    private final ComponentOrderRepository componentOrderRepository;

    public ComponentOrderService(ComponentOrderRepository componentOrderRepository) {
        this.componentOrderRepository = componentOrderRepository;
    }

    public void save(ComponentOrderDto dto) {
        log.info("saving log of ComponentOrder");

        componentOrderRepository.save(new ComponentOrder()
                .setOrderId(dto.getOrderId())
                .setComponent(dto.getComponent())
                .setTime(dto.getTime()));
    }
}
