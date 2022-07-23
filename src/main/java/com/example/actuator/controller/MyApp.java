package com.example.actuator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/myapp")
public class MyApp {

    @GetMapping("/status")
    public ResponseEntity<Map> getStatus() {
        Map<String, String> result = new HashMap<>();
        result.put("message", "Myapp is Up and Running...");
//        return ResponseEntity.ok().body(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
