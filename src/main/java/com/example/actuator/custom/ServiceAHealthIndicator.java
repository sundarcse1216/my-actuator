package com.example.actuator.custom;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ServiceAHealthIndicator implements HealthIndicator {
    private final String service = "Service A";

    @Override
    public Health health() {
        if (isRunningServiceA()) {
            return Health.up().withDetail(service, "Available").build();
        } else {
            return Health.down().withDetail(service, "Not Available").build();
        }
    }

    private Boolean isRunningServiceA() {
        Boolean isRunning = true;
        // Logic Skipped

        return isRunning;
    }
}
