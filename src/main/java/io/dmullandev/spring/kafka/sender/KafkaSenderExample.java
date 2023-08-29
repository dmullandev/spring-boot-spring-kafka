package io.dmullandev.spring.kafka.sender;

import static io.dmullandev.spring.kafka.constants.ApplicationConstants.TOPIC_NAME_1;

import java.util.concurrent.CompletableFuture;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

@Component
public class KafkaSenderExample {

    private KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger LOG = LogManager.getLogger();

    @Autowired
    KafkaSenderExample(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // convenient method to send message using topicName and providing a message
    void sendMessage(String message, String topicName) {
        kafkaTemplate.send(topicName, message);

    }

    void sendMessageWithCallback(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC_NAME_1, message);

        future.whenComplete((sendResult, exception) -> {
            if (sendResult != null) {
                LOG.info("Message [{}] delivered with offset {}", message, sendResult.getRecordMetadata().offset());
            } else {
                LOG.warn("Unable to deliver message [{}]. {}", message, exception.getMessage());
            }
        });
        // future.compl
    }
}