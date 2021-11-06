package org.jo.training.gatewayservice.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerFilterFactory;
import org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerResilience4JFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.DispatcherHandler;

@Configuration
public class CircuitBreakerConfig {

    @Bean
    public SpringCloudCircuitBreakerFilterFactory circuitBreakerResilience4JFilter(ReactiveCircuitBreakerFactory reactiveCircuitBreakerFactory,
                                                                                   ObjectProvider<DispatcherHandler> dispatcherHandlerProvider) {
        return new SpringCloudCircuitBreakerResilience4JFilterFactory(reactiveCircuitBreakerFactory, dispatcherHandlerProvider);
    }
}
