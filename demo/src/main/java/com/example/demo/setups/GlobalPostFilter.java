package com.example.demo.setups;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@Configuration
public class GlobalPostFilter {
	
	@Bean
	public GlobalFilter postGlobalFilter() {
		return (exchange,chain) ->{
			return chain.filter(exchange)
					.then(Mono.fromRunnable(()->{
						System.out.println("Global postFilter!!");
					}));
		};
	}

}