package com.example.actuator.custom;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;


@Component
public class ServiceBHealthIndicator implements HealthIndicator {

    private final String service = "Service B";

    @Override
    public Health health() {
        if (!isRunningServiceB()) {
            return Health.down().withDetail(service, "Not Available").build();
        }
        return Health.up().withDetail(service, "Available").build();
    }

    private Boolean isRunningServiceB() {
        Boolean isRunning = false;
        // Logic Skipped

        return isRunning;
    }
}
