package com.tp.schoolproject.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    private int check() {
        // Lógica para verificar a saúde do serviço
        // Retorna 0 se o serviço estiver saudável, qualquer outro valor caso contrário
        boolean serviceIsHealthy = true; // Suponha que o serviço está saudável

        if (serviceIsHealthy) {
            return 0;
        } else {
            return 1; // ou outro código de erro relevante
        }
    }
}