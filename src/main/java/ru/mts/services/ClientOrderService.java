package ru.mts.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mts.dto.ClientOrderDto;
import ru.mts.entities.ClientOrder;
import ru.mts.repositories.ClientOrderRepository;

@Service
@Slf4j
public class ClientOrderService {

    private final ClientOrderRepository clientOrderRepository;

    public ClientOrderService(ClientOrderRepository clientOrderRepository) {
        this.clientOrderRepository = clientOrderRepository;
    }

    public void save(ClientOrderDto dto) {
        log.info("saving log of ClientOrder");

        clientOrderRepository.save(new ClientOrder()
                .setOrderId(dto.getOrderId())
                .setTime(dto.getTime())
                .setCompleted(dto.isCompleted()));
    }
}
