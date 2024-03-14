package org.example;

import org.example.entities.Order;
import org.example.services.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producer")
public class AppController {

    @Autowired
    CreatorService service;

    @PostMapping("/produce")
    public ResponseEntity<String> produceProducts(@RequestBody Order order) {
        try {
            service.produceOrder(order);
        } catch (InterruptedException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}
