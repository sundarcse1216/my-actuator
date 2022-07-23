package com.example.actuator.controller;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Component
@RestControllerEndpoint(id = "custom")
public class CustomEndPointController {

    @GetMapping("/myapi")
    public @ResponseBody ResponseEntity customEndPoint() {
        Map<String, String> result = new HashMap<>();
        result.put("message", "Service Up and Running...");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
