package com.kafkaproducer;

import com.kafkaproducer.controller.EventController;
import com.kafkaproducer.service.KafkaMessagePublisher;
import kafka.controller.KafkaController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Nazim Uddin Asif
 * @Since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaIntegrationTest {

    @Autowired
     private KafkaMessagePublisher kafkaMessagePublisher;
    @Autowired
    private EventController kafkaController;

    private final CountDownLatch latch = new CountDownLatch(1);
    private String receivedMessage = null;

    @KafkaListener(topics = "event2", groupId = "group-1")
    public void receive(String message) {
        this.receivedMessage = message;
        latch.countDown(); // Signal that the message was received
    }

    @Test
    @DirtiesContext
    public void testSendMessage() throws InterruptedException {
        String testMessage = "Hello Kafka";
        kafkaController.doPublish(testMessage);
        kafkaMessagePublisher.pushMessage(testMessage.toString());

//        kafkaTemplate.send("event2", testMessage);

        // Wait for the message to be received
        assertTrue(latch.await(5, TimeUnit.SECONDS));

        // Assert that the message was correctly received and processed
//        assertEquals(testMessage, receivedMessage);
    }
}

