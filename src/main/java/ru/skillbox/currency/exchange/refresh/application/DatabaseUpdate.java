package ru.skillbox.currency.exchange.refresh.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.skillbox.currency.exchange.dto.CurrencyDto;
import ru.skillbox.currency.exchange.repository.CurrencyRepository;
import ru.skillbox.currency.exchange.service.ApplicationService;
import ru.skillbox.currency.exchange.service.CurrencyService;

import java.util.HashSet;

@Component
@Slf4j
public class DatabaseUpdate implements ApplicationService {

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private CurrencyService service;

    @Autowired
    private LoadCurrentCurrency loadCurrentCurrency;

    @Autowired
    private CurrencyRepository currencyRepository;


    @Override
    public void updateCurrency(CurrencyDto dto) {

        log.info("Update currency on database initial(DatabaseUpdate.class) at time: {}", System.currentTimeMillis());

        String sql = "UPDATE currency SET"
                .concat(" valute_id = ?, iso_num_code = ? ,iso_char_code = ?, nominal = ?, name = ?, value = ?,")
                .concat(" v_unit_rate = ? WHERE id = ?");

        template.update(sql,
                dto.getValuteId(),
                dto.getIsoNumCode(),
                dto.getIsoCharCode(),
                dto.getNominal(),
                dto.getName(),
                dto.getValue(),
                dto.getVUnitRate(),
                dto.getId());
    }

    public void refreshData() {
        log.info("\nInitial update database at time: {}\n", System.currentTimeMillis());
        HashSet<CurrencyDto> currencyDtoList = new HashSet<>(service.getAll());

        HashSet<Long> isoNumCodes = new HashSet<>();
        HashSet<Long> currenciesId = new HashSet<>();

        for (CurrencyDto currency : currencyDtoList) {
            isoNumCodes.add(currency.getIsoNumCode());
            currenciesId.add(currency.getId());
        }
        for (CurrencyDto dto : loadCurrentCurrency.updatedCurrency()) {
            if (isoNumCodes.contains(dto.getIsoNumCode()) || currenciesId.contains(dto.getId())) {
                dto.setId(currencyRepository.findByIsoNumCode(dto.getIsoNumCode()).getId());
                updateCurrency(dto);
            } else {
                service.create(dto);
            }
        }
        log.info("\nUpdate successful! At time: {}\n", System.currentTimeMillis());
    }
}
