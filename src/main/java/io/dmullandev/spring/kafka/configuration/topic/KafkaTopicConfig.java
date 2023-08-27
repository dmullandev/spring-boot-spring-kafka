package io.dmullandev.spring.kafka.configuration.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("io-dmullandev-1").build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("io-dmullandev-2").build();
    }
}