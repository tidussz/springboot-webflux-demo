package com.javatechie.webflux;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

	@Test
	public void testMono() {
		
		// On complete called
		Mono<String> monoString = Mono.just("javatechie").log();
		monoString.subscribe(System.out::println, e->System.out.println(e.getMessage()));
		
		// There is an error, on complete not called
		Mono<Object> monoString2 = Mono.just("javatechie")
				.then(Mono.error(new RuntimeException("Exception occured")))
				.log();
		monoString2.subscribe(System.out::println, e->System.out.println(e.getMessage()));
	}
	
	@Test
	public void testFlux() {
		// On complete called
		Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservices")
				.concatWithValues("AWS")
				.log();
		fluxString.subscribe(System.out::println);
		
		// There is an error, on complete not called
		Flux<String> fluxString2 = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservices")
				.concatWithValues("AWS")
				.concatWith(Flux.error(new RuntimeException("Exception occured in Flux")))
				.concatWithValues("Cloud")
				.log();
		fluxString2.subscribe(System.out::println, e->System.out.println(e.getMessage()));
	}
}
