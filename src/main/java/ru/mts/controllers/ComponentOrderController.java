package ru.mts.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mts.dto.ComponentOrderDto;
import ru.mts.services.ComponentOrderService;

@RestController
@RequestMapping("/api/history/componentOrder")
public class ComponentOrderController {

    private final ComponentOrderService componentOrderService;

    public ComponentOrderController(ComponentOrderService componentOrderService) {
        this.componentOrderService = componentOrderService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveLog(ComponentOrderDto dto) {
        componentOrderService.save(dto);
        return ResponseEntity.ok().build();
    }
}
