package com.springboot.project.cloudgateway.config;

import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

import static io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType.COUNT_BASED;

@Configuration
public class ResilienceConfig {
    @Bean
    public CircuitBreakerConfigCustomizer hotelServiceCircuitBreaker() {
        return CircuitBreakerConfigCustomizer
                .of("hotelServiceFallBackMethod", builder -> {
                    builder.slidingWindowSize(5);
                    builder.failureRateThreshold(3);
                    builder.waitDurationInOpenState(Duration.ofSeconds(10));
                    builder.slowCallDurationThreshold(Duration.ofSeconds(5));
                    builder.slowCallRateThreshold(100);
                    builder.permittedNumberOfCallsInHalfOpenState(2);
                    builder.slidingWindowType(COUNT_BASED);
                });
    }

    @Bean
    public CircuitBreakerConfigCustomizer guestServiceCircuitBreaker() {
        return CircuitBreakerConfigCustomizer
                .of("guestServiceFallBackMethod", builder -> {
                    builder.slidingWindowSize(5);
                    builder.failureRateThreshold(3);
                    builder.waitDurationInOpenState(Duration.ofSeconds(10));
                    builder.slowCallDurationThreshold(Duration.ofSeconds(5));
                    builder.slowCallRateThreshold(100);
                    builder.permittedNumberOfCallsInHalfOpenState(2);
                    builder.slidingWindowType(COUNT_BASED);
                });
    }

    @Bean
    public CircuitBreakerConfigCustomizer reservationServiceCircuitBreaker() {
        return CircuitBreakerConfigCustomizer
                .of("reservationServiceFallBackMethod", builder -> {
                    builder.slidingWindowSize(5);
                    builder.failureRateThreshold(3);
                    builder.waitDurationInOpenState(Duration.ofSeconds(10));
                    builder.slowCallDurationThreshold(Duration.ofSeconds(5));
                    builder.slowCallRateThreshold(100);
                    builder.permittedNumberOfCallsInHalfOpenState(2);
                    builder.slidingWindowType(COUNT_BASED);
                });
    }

    @Bean
    public CircuitBreakerConfigCustomizer eventSourceCqrsServiceFallBackMethod() {
        return CircuitBreakerConfigCustomizer
                .of("eventSourceCqrsServiceFallBackMethod", builder -> {
                    builder.slidingWindowSize(5);
                    builder.failureRateThreshold(3);
                    builder.waitDurationInOpenState(Duration.ofSeconds(10));
                    builder.slowCallDurationThreshold(Duration.ofSeconds(5));
                    builder.slowCallRateThreshold(100);
                    builder.permittedNumberOfCallsInHalfOpenState(2);
                    builder.slidingWindowType(COUNT_BASED);
                });
    }
}