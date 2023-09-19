package io.dmullandev.kafka.consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import io.dmullandev.kafka.consumer.repository.WikimediaDataRepository;

/**
 * Test class for {@link KafkaWikimediaConsumer}
 * 
 * @author dmullandev
 *
 */
@SpringBootTest(classes = KafkaWikimediaConsumer.class)
@TestPropertySource(properties = {
        "spring.kafka.consumer.auto-offset-reset=earliest",
        "spring.datasource.url=jdbc:tc:mysql:8.0.32:///db",
})
@Testcontainers
public class KafkaWikimediaConsumerKafkaContainerIntegrationTest {
    private static final Logger LOG = LogManager.getLogger(KafkaWikimediaConsumerKafkaContainerIntegrationTest.class);

    @Container
    public static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:.7.5.0"));

    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", kafka::getBootstrapServers);
    }

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private WikimediaDataRepository wikimediaDataRepository;
}
