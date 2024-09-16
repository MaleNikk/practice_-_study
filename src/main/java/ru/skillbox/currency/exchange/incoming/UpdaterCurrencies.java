package ru.skillbox.currency.exchange.incoming;

import ru.skillbox.currency.exchange.dto.CurrencyDto;

import java.util.List;

public interface UpdaterCurrencies {

    List<CurrencyDto> updatedCurrency();
}
