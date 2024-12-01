package ru.skillbox.currency.exchange.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableAsync
@ConditionalOnProperty(name = "app.update.enable",matchIfMissing = true)
public class ApplicationScheduler {
}
