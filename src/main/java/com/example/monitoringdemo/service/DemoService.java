package com.example.monitoringdemo.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@Slf4j
public class DemoService {

    private final Random random = new Random();
    private final Counter dataGeneratedCounter;
    
    public DemoService(MeterRegistry registry) {
        this.dataGeneratedCounter = Counter.builder("app.data.generated")
                .description("Number of data generations")
                .register(registry);
    }
    
    public Map<String, Object> generateData() {
        dataGeneratedCounter.increment();
        
        Map<String, Object> data = new HashMap<>();
        data.put("timestamp", System.currentTimeMillis());
        data.put("value", random.nextInt(100));
        data.put("active", random.nextBoolean());
        
        log.debug("Generated data: {}", data);
        return data;
    }
}