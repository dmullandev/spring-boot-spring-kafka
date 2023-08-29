package io.dmullandev.kafka.producer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    private static final Logger log = LogManager.getLogger(KafkaProducer.class);

    private static final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private KafkaTemplate<String, String> kafkaTemplate;

    KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    void sendMessage(String message, String topicName) {
        kafkaTemplate.send(topicName, message);
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        String timestamp = dateTimeFormat.format(LocalDateTime.now());
        sendMessage(timestamp, "timestamp");
        log.info("Sent: {}", timestamp);
    }
}