package com.microservices.reference.user_service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductConsumer {

    @KafkaListener(topics = "products", groupId = "user-service-group")
    public void consume(String message) {
        log.info("::: PRODUTO RECEBIDO: ".concat(message));
    }
}
