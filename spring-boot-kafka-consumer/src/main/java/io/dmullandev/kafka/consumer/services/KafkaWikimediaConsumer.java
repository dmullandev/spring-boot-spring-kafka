package io.dmullandev.kafka.consumer.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import io.dmullandev.kafka.constants.KafkaAppConstants;

/**
 * Consumer for wikimedia events on the wikimedia topic.
 * 
 * @author dan
 *
 */
@Service
public class KafkaWikimediaConsumer {

    private static final Logger LOG = LogManager.getLogger(KafkaWikimediaConsumer.class);

    @KafkaListener(topics = KafkaAppConstants.APP_TOPIC_WIKIMEDIA, groupId = KafkaAppConstants.APP_TOPIC_BASE + "-group")
    void listenerWikimediaEvent(String wikimediaEvent) {
        LOG.info("Receiving wikimediaEvent: {}", wikimediaEvent);
    }
}
