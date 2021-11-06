package org.jo.training.gatewayservice.config;

import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfig {
    @Bean
    RouteLocator staticRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        /*
         * API name : EU Covid-19 Travel
         * https://eu-covid-19-travel.p.rapidapi.com/ : possible suffix /data | /country/:country | /travel/:country
         */
        return routeLocatorBuilder.routes()
                .route("covid-route", r -> r.path("/covid-19/**")
                        .filters(f ->
                                f.addRequestHeader("x-rapidapi-host", "eu-covid-19-travel.p.rapidapi.com")
                                        .addRequestHeader("x-rapidapi-key", "26a5d47c7cmshdb5eddff0410717p181373jsn6ca4e2ba02f2")
                                        .rewritePath("/covid-19/(?<segment>.*)", "/${segment}") // override 'path' value and keep only 'segment' value for uri
                                        .circuitBreaker(b -> b.setName("covid").setFallbackUri("forward:/defaultData"))
                        ).uri("https://eu-covid-19-travel.p.rapidapi.com/")
                ).build();
    }

    @Bean
    DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {
        return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
    }
}
