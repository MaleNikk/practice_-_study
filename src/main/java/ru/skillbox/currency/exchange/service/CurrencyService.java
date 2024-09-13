package ru.skillbox.currency.exchange.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skillbox.currency.exchange.dto.CurrencyDto;
import ru.skillbox.currency.exchange.storage.ApplicationStorage;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyService implements ApplicationService{

    @Autowired
    private final ApplicationStorage storage;

    public CurrencyDto getById(Long id) {
        log.info("CurrencyService method getById executed");
        return storage.getById(id);
    }

    public Double convertValue(Long value, Long numCode) {
        log.info("CurrencyService method convertValue executed");
        return storage.convertValue(value,numCode);
    }

    public CurrencyDto create(CurrencyDto dto) {
        log.info("CurrencyService method create executed");
        return  storage.create(dto);
    }

    public List<CurrencyDto> getAll(){
        log.info("CurrencyService method getAll executed");
        return storage.getAll();
    }

    @Override
    public void updateCurrency(CurrencyDto dto) {
        log.info("Update currency on database initial(DatabaseUpdate.class) at time: {}", System.currentTimeMillis());
        storage.updateCurrency(dto);
    }

    public void refreshData() {
        log.info("\nInitial update database at time: {}\n", System.currentTimeMillis());
        storage.updateCurrenciesInDb();
    }
}
