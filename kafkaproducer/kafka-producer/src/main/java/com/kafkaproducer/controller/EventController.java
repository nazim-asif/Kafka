package com.kafkaproducer.controller;

import com.kafkaproducer.dto.Customer;
import com.kafkaproducer.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nazim Uddin Asif
 * @Since 1.0.0
 */
@RestController
@RequestMapping("/kafka")
public class EventController {
    @Autowired
    private KafkaMessagePublisher publisher;
    @GetMapping("/producer/{message}")
    public String doPublish(@PathVariable String message){
        for (int i = 0; i < 10; i++) {
            publisher.pushMessage(message);
        }

        return "Successful";
    }
    @GetMapping("/producer")
    public String doPublish1(){
        /*for (int i = 0; i < 10; i++) {
//            publisher.pushMessage();
        }
*/
        return "Successful";
    }
    @PostMapping("/publish")
    public void sendEvents(@RequestBody Customer customer) {
        publisher.sendEventsToTopic(customer);
    }
}
