package io.dmullandev.spring.kafka.configuration.topic;

import static io.dmullandev.spring.kafka.constants.ApplicationConstants.TOPIC_NAME_1;
import static io.dmullandev.spring.kafka.constants.ApplicationConstants.TOPIC_NAME_2;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name(TOPIC_NAME_1).build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name(TOPIC_NAME_2).build();
    }
}