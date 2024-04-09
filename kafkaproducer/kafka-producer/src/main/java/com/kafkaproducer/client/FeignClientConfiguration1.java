/*
package com.kafkaproducer.client;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.loadbalancer.blocking.client.BlockingLoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.loadbalancer.LoadBalancerFeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/**
 * @author Nazim Uddin Asif
 * @Since 1.0.0
 *//*

@Configuration
@EnableFeignClients(basePackages = "com.kafkaproducer.client")
public class FeignClientConfiguration1 {

    private final BlockingLoadBalancerClient loadBalancerClient;

    public FeignClientConfiguration1(ObjectProvider<BlockingLoadBalancerClient> loadBalancerClientObjectProvider) {
        this.loadBalancerClient = loadBalancerClientObjectProvider.getIfAvailable();
    }

    @Bean
    public FeignClient feignClient() {
        return new LoadBalancerFeignClient(new DefaultFeignLoadBalancer(loadBalancerClient));
    }
}
*/
