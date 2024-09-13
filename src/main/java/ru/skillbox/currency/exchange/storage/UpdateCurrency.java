package ru.skillbox.currency.exchange.storage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.skillbox.currency.exchange.service.ApplicationService;

import static java.lang.Thread.sleep;

@Service
@Scope("singleton")
@Slf4j
public class UpdateCurrency implements Runnable {

    @Value("${app.update.time}")
    private Long timeUpdate;

    @Value("${app.update.enable}")
    private boolean enable;

    @Autowired
    private ApplicationService serviceCurrency;

    @Override
    public void run() {
        Thread thread = new Thread(this);
        thread.start();
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
                }
            } while (Thread.currentThread().isAlive());
        } catch (InterruptedException exception) {
            log.info("We caught exception, please check your internet connection! ");
            this.run();
        }
    }
}
