package ru.mts.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mts.dto.ClientOrderDto;
import ru.mts.services.ClientOrderService;

@RestController
@RequestMapping("/api/history/clientOrders")
public class ClientOrderController {

    private final ClientOrderService clientOrderService;

    public ClientOrderController(ClientOrderService clientOrderService) {
        this.clientOrderService = clientOrderService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveLog(ClientOrderDto dto) {
        clientOrderService.save(dto);
        return ResponseEntity.ok().build();
    }
}
