package com.example.monitoringdemo.scheduler;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class SimulationScheduler {

    private final Random random = new Random();
    private final AtomicInteger userCount = new AtomicInteger(0);
    
    public SimulationScheduler(MeterRegistry registry) {
        Gauge.builder("app.users.active", userCount::get)
                .description("Number of active users")
                .register(registry);
    }
    
    @Scheduled(fixedRate = 5000)
    public void simulateUserActivity() {
        // Simulate users joining/leaving
        int delta = random.nextInt(10) - 4; // -4 to +5
        int newCount = Math.max(0, userCount.addAndGet(delta));
        userCount.set(newCount);
        
        log.info("Active users: {}", newCount);
    }
    
    @Scheduled(fixedRate = 15000)
    public void simulateSystemActivity() {
        // Simulate CPU usage spikes occasionally
        if (random.nextInt(4) == 0) {
            log.warn("CPU usage spike detected!");
            // Simulate CPU load
            for (int i = 0; i < 1000000; i++) {
                Math.sqrt(random.nextDouble());
            }
        }
        
        // Simulate memory usage
        int memoryUsageMB = 100 + random.nextInt(400);
        log.debug("Current memory usage: {} MB", memoryUsageMB);
    }
}