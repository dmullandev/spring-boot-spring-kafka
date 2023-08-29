package io.dmullandev.kafka.consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private static final Logger log = LogManager.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "timestamp")
    void listener(String timestamp) {
        log.info("Received: {}", timestamp);
    }
}