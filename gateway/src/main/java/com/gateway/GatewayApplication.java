package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
    
    @Bean
	RouteLocator routes(RouteLocatorBuilder builder){
		return builder.routes()
				.route(r -> r.path("/api/**").uri("lb://users"))
				.route(r -> r.path("/api/**").uri("lb://taxe-service"))
				.build();
	}

	//Pour Configuration Dynamique

	@Bean
	DiscoveryClientRouteDefinitionLocator
	routesDynamique(ReactiveDiscoveryClient rdc , DiscoveryLocatorProperties dlp)
	{
		return  new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
	}

}
