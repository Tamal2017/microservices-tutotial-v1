package org.jo.training.gatewayservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CircuitBreakerController {

    @GetMapping("/defaultData")
    public Map<String, String> defaultCountries() {
        Map<String, String> response = new HashMap<>();
        response.put("Message", "Default data for Covid-19 around the world");
        response.put("national_cases", "692");
        response.put("national_population", "626108");
        response.put("national_testing_rate", "2482.63877797441");
        response.put("national_positivity_rate", "4.45187853834277");

        return response;
    }
}
