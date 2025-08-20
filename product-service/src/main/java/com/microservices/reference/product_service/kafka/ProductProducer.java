package com.microservices.reference.product_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "products";

    public ProductProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendProductEvent(String productMessage) {
        kafkaTemplate.send(TOPIC, productMessage);
        System.out.println("📤 Produto publicado: " + productMessage);
    }
}
