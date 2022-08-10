package com.example.springboottutorial.health;

import com.example.springboottutorial.configuration.SpringBootTutorialConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TemplateHealthCheck implements HealthIndicator {

    private final SpringBootTutorialConfiguration configuration;

    @Autowired
    public TemplateHealthCheck(SpringBootTutorialConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Health health() {
        final String saying = String.format(configuration.getTemplate(), "TEST");
        if (!saying.contains("TEST")) {
            return Health.down().withDetail("errro", "template doesnt include a name")
                    .build();
        }
        return Health.up().build();
    }
}
