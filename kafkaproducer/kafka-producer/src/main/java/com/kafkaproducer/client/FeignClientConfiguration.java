package com.kafkaproducer.client;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author Nazim Uddin Asif
 * @Since 1.0.0
 */
@Configuration
public class FeignClientConfiguration {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public DynamicUrlInterceptor dynamicUrlInterceptor(DynamicUrlService dynamicUrlService) {
        return new DynamicUrlInterceptor(dynamicUrlService);
    }
}