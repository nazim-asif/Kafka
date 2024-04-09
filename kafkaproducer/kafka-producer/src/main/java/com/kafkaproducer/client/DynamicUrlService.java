package com.kafkaproducer.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DynamicUrlService {

/*    private final DynamicUrlRepository dynamicUrlRepository;

    @Autowired
    public DynamicUrlService(DynamicUrlRepository dynamicUrlRepository) {
        this.dynamicUrlRepository = dynamicUrlRepository;
    }*/

    public String getDynamicUrl() {
        // Implement logic to fetch the dynamic URL from the database
        return "http//:localhost:9191/kafka/producer/abc";
    }
}
