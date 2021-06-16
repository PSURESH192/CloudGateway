package com.springboot.project.CloudGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/hotelServiceFallBackMethod")
    public String hotelServiceFallBackMethod(){
        return "Hotel Service took longer time than expected.Please try again after sometime";
    }

    @GetMapping("/guestServiceFallBackMethod")
    public String guestServiceFallBackMethod(){
        return "Guest Service took longer time than expected.Please try again after sometime";
    }
}
