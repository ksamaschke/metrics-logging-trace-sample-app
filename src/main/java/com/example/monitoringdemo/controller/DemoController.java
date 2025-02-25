package com.example.monitoringdemo.controller;

import com.example.monitoringdemo.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class DemoController {

    private final DemoService demoService;
    private final Random random = new Random();

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        log.info("Hello endpoint called");
        return ResponseEntity.ok("Hello from Monitoring Demo!");
    }
    
    @GetMapping("/data")
    public ResponseEntity<Map<String, Object>> getData() {
        log.info("Data endpoint called");
        return ResponseEntity.ok(demoService.generateData());
    }
    
    @GetMapping("/slow")
    public ResponseEntity<String> slowEndpoint() throws InterruptedException {
        log.info("Slow endpoint called");
        // Simulate variable response time
        int delay = 100 + random.nextInt(900);
        Thread.sleep(delay);
        return ResponseEntity.ok("Slow response after " + delay + "ms");
    }
    
    @GetMapping("/error")
    public ResponseEntity<String> errorEndpoint() {
        log.error("Error endpoint called");
        // Randomly generate errors (20% chance)
        if (random.nextInt(5) == 0) {
            throw new RuntimeException("Simulated random error");
        }
        return ResponseEntity.ok("No error this time!");
    }
}