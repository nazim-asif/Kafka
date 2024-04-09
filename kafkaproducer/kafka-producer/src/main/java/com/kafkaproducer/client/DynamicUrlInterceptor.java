package com.kafkaproducer.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Nazim Uddin Asif
 * @Since 1.0.0
 */
@Component
public class DynamicUrlInterceptor implements RequestInterceptor {

    private final DynamicUrlService dynamicUrlService;

    @Autowired
    public DynamicUrlInterceptor(DynamicUrlService dynamicUrlService) {
        this.dynamicUrlService = dynamicUrlService;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String dynamicUrl = dynamicUrlService.getDynamicUrl();
        String fullUrl = dynamicUrl + requestTemplate.url();
        requestTemplate.target(dynamicUrl);
    }
}
