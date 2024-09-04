package ru.skillbox.currency.exchange.service;

import ru.skillbox.currency.exchange.dto.CurrencyDto;


public interface ApplicationService {

    void updateCurrency(CurrencyDto dto);

    void refreshData();

}
