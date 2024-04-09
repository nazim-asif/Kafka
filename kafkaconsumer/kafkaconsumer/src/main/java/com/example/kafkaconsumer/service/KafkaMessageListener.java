package com.example.kafkaconsumer.service;

import com.example.kafkaconsumer.dto.Customer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

/**
 * @author Nazim Uddin Asif
 * @Since 1.0.0
 */
@Service
public class KafkaMessageListener {

   /* @KafkaListener(topics = "event",groupId = "group-1")
    public void consumeEvents(Customer customer) {
        System.out.println("consumer consume the events {} "+ customer.toString());
    }*/

     @KafkaListener(topics = "event2",groupId = "group-1",
                    topicPartitions = {@TopicPartition(topic = "event2", partitions = {"2"})})
    public void consumeEvents(String message) {
        System.out.println("consumer consume the events "+ message);
    }

    @KafkaListener(topics = "event1", groupId = "group-1")
    public void consume(String message){
        System.out.println("Consumer1 Message: "+ message);
    }
   /* @KafkaListener(topics = "event1", groupId = "group-1")
    public void consume2(String message){
        System.out.println("Consumer2 Message: "+ message);
    }
    @KafkaListener(topics = "event1", groupId = "group-1")
    public void consume3(String message){
        System.out.println("Consumer3 Message: "+ message);
    }*/
}
