package com.springboot.project.cloudgateway.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @CircuitBreaker(name = "hotelServiceFallBackMethod", fallbackMethod = "hotelServiceFallBackMethod")
    @GetMapping("/hotelServiceFallBackMethod")
    public String hotelServiceFallBackMethod(Exception e){
        return "Hotel Service took longer time than expected.Please try again after sometime";
    }

    @CircuitBreaker(name = "guestServiceFallBackMethod", fallbackMethod = "guestServiceFallBackMethod")
    @GetMapping("/guestServiceFallBackMethod")
    public String guestServiceFallBackMethod(Exception e){
        return "Guest Service took longer time than expected.Please try again after sometime";
    }

    @CircuitBreaker(name = "reservationServiceFallBackMethod", fallbackMethod = "reservationServiceFallBackMethod")
    @GetMapping("/reservationServiceFallBackMethod")
    public String reservationServiceFallBackMethod(Exception e){
        return "Reservation Service took longer time than expected.Please try again after sometime";
    }
}
