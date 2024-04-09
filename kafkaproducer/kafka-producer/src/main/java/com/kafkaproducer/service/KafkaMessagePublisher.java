package com.kafkaproducer.service;

import com.kafkaproducer.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * @author Nazim Uddin Asif
 * @Since 1.0.0
 */
@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String,Object> template;
    public void pushMessage(String message){

        CompletableFuture<SendResult<String, Object>> firstEvent = template.send("event2", 2,null,message);
        firstEvent.whenComplete((result,ex)->{
            if(Objects.isNull(ex)){
                System.out.println("message: "+ message + " Offset: " + result.getRecordMetadata().offset()
                        + " Partition: "+ result.getRecordMetadata().partition());

            }else {
                System.out.println("Message: "+ message + " exception: "+ ex);
            }

        });

    }

    public void sendEventsToTopic(Customer customer) {
        try {
            CompletableFuture<SendResult<String, Object>> future = template.send("event", customer);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent message=[" + customer.toString() +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            customer.toString() + "] due to : " + ex.getMessage());
                }
            });

        } catch (Exception ex) {
            System.out.println("ERROR : "+ ex.getMessage());
        }
    }
}
