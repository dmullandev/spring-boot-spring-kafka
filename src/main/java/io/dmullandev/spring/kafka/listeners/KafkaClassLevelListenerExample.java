package io.dmullandev.spring.kafka.listeners;

import static io.dmullandev.spring.kafka.constants.ApplicationConstants.TOPIC_NAME_3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "class-level", topics = TOPIC_NAME_3)
public class KafkaClassLevelListenerExample {

    private static final Logger LOG = LogManager.getLogger();

    @KafkaHandler
    void listen(String message) {
        LOG.info("KafkaHandler[String] {}", message);
    }

    @KafkaHandler(isDefault = true)
    void listenDefault(Object object) {
        LOG.info("KafkaHandler[Default] {}", object);
    }
}
