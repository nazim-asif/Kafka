package com.kafkaproducer;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;

/**
 * @author Nazim Uddin Asif
 * @Since 1.0.0
 */
@SpringBootTest(classes = KafkaProducerApplication.class)
@EmbeddedKafka(brokerProperties = {"listeners=PLAINTEXT://localhost:9094"},partitions = 1)
public class ConsumerServiceTest {

    @Autowired
    KafkaTemplate template;

    @Test
    void test() throws InterruptedException{
        template.send("event2","test");
    }

}
