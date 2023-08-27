package io.dmullandev.spring.kafka.listeners;

import static io.dmullandev.spring.kafka.constants.ApplicationConstants.GROUP_TOPIC_NAME_2;
import static io.dmullandev.spring.kafka.constants.ApplicationConstants.GROUP_TOPIC_NAME_3;
import static io.dmullandev.spring.kafka.constants.ApplicationConstants.TOPIC_NAME_1;
import static io.dmullandev.spring.kafka.constants.ApplicationConstants.TOPIC_NAME_2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;;

@Component
public class KafkaListenersExample {

    private static final Logger LOG = LogManager.getLogger();

    @KafkaListener(topics = TOPIC_NAME_1)
    void listener(String data) {
        LOG.info(data);
    }

    @KafkaListener(topics = TOPIC_NAME_1 + ", " + TOPIC_NAME_2, groupId = GROUP_TOPIC_NAME_2)
    void commonListenerForMultipleTopics(String message) {
        LOG.info("MultipleTopicListener - {}", message);
    }

    /**
     * As an initial offset of 0 is specified, when the application is started or
     * restarted then every record will be read off the
     * 
     * @param message   the received message
     * @param partition the partition
     * @param offset    the offset
     */
    @KafkaListener(groupId = GROUP_TOPIC_NAME_3, topicPartitions = @TopicPartition(topic = TOPIC_NAME_1, partitionOffsets = {
            @PartitionOffset(partition = "0", initialOffset = "0") }))
    void listenToPartitionWithOffset(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Header(KafkaHeaders.OFFSET) int offset) {
        LOG.info("Received message [{}] from partition-{} with offset-{}",
                message,
                partition,
                offset);
    }
}