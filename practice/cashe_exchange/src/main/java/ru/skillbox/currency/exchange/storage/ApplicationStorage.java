package ru.skillbox.currency.exchange.storage;

import ru.skillbox.currency.exchange.dto.CurrencyDto;

import java.util.List;

public interface ApplicationStorage {

    CurrencyDto getById(Long id);

    Double convertValue(Long value, Long numCode);

    CurrencyDto create(CurrencyDto dto);

    List<CurrencyDto> getAll();

    void updateCurrency(CurrencyDto dto);

    void updateCurrenciesInDb();
}
