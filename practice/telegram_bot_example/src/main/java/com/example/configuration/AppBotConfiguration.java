package com.example.configuration;

import com.example.exception.AppBotException;
import com.example.management.AppBotManagement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
@Slf4j
public class AppBotConfiguration {

    @Bean
    TelegramBotsApi telegramManagement(AppBotManagement appBotManagement) {
        TelegramBotsApi botsApi;
        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(appBotManagement);
            log.info("Telegram management registered at system time: {}", System.currentTimeMillis());
        } catch (AppBotException | TelegramApiException exception) {
            log.error("Error occurred while sending message to telegram!", exception);
            return null;
        }
        return botsApi;
    }
}
