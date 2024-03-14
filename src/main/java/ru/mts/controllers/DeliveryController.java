package ru.mts.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mts.dto.DeliveryDto;
import ru.mts.services.DeliveryService;

@RestController
@RequestMapping("/api/history/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveLog(DeliveryDto dto) {
        deliveryService.save(dto);
        return ResponseEntity.ok().build();
    }
}
