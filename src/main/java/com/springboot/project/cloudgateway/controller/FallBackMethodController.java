package com.springboot.project.cloudgateway.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @CircuitBreaker(name = "hotelServiceFallBackMethod", fallbackMethod = "hotelServiceFallBackMethod")
    @GetMapping("/hotelServiceFallBackMethod")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    public String hotelServiceFallBackMethod(Exception e){
        return "Hotel Service took longer time than expected.Please try again after sometime";
    }

    @CircuitBreaker(name = "guestServiceFallBackMethod", fallbackMethod = "guestServiceFallBackMethod")
    @GetMapping("/guestServiceFallBackMethod")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    public String guestServiceFallBackMethod(Exception e){
        return "Guest Service took longer time than expected.Please try again after sometime";
    }

    @CircuitBreaker(name = "reservationServiceFallBackMethod", fallbackMethod = "reservationServiceFallBackMethod")
    @GetMapping("/reservationServiceFallBackMethod")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    public String reservationServiceFallBackMethod(Exception e){
        return "Reservation Service took longer time than expected.Please try again after sometime";
    }
}
