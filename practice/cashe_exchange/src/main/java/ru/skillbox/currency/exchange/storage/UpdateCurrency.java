package ru.skillbox.currency.exchange.storage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.skillbox.currency.exchange.service.ApplicationService;

@Service
@Slf4j
public class UpdateCurrency {

    @Autowired
    private ApplicationService serviceCurrency;

    @Async
    @Scheduled(fixedRate = 3600000)
    public void enjoyUpdate() {
        log.info("Initial auto update!\n");
        serviceCurrency.refreshData();
        log.info("Auto update successful!\n");
    }
}
