package ru.skillbox.currency.exchange.refresh.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.skillbox.currency.exchange.service.ApplicationService;

import static java.lang.Thread.sleep;

@Component
@Scope("singleton")
@Slf4j
public class ThreadUpdateCurrency implements Runnable {

    @Value("${app.update.time}")
    private Long timeUpdate;

    @Value("${app.update.enable}")
    private boolean enable;

    @Autowired
    private ApplicationService serviceCurrency;

    @Override
    public void run() {
        Thread thread = new Thread(this);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void enjoyUpdate() {
        try {
            do {
                if (enable) {
                    log.info("Initial auto update!\n");
                    serviceCurrency.refreshData();
                    sleep(timeUpdate);
                } else {
                    log.info("Auto update d't enable!\n");
                    sleep(timeUpdate);
                }
            } while (Thread.currentThread().isAlive());
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }
}
