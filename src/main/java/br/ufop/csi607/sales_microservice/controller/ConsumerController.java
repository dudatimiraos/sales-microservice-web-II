package br.ufop.csi607.sales_microservice.controller;

import br.ufop.csi607.sales_microservice.model.Consumer;
import br.ufop.csi607.sales_microservice.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @PostMapping
    public ResponseEntity<?> createConsumer(@RequestBody Consumer consumer) {
        try {
            Consumer newConsumer = consumerService.createConsumer(consumer);
            return new ResponseEntity<>(newConsumer, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Consumer>> getAllConsumers() {
        List<Consumer> consumers = consumerService.getAllConsumers();
        return ResponseEntity.ok(consumers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consumer> getConsumerById(@PathVariable UUID id) {
        return consumerService.getConsumerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consumer> updateConsumer(@PathVariable UUID id, @RequestBody Consumer consumerDetails) {
        try {
            Consumer updatedConsumer = consumerService.updateConsumer(id, consumerDetails);
            return ResponseEntity.ok(updatedConsumer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsumer(@PathVariable UUID id) {
        try {
            consumerService.deleteConsumer(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}