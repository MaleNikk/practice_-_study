package ru.skillbox.currency.exchange.storage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.skillbox.currency.exchange.dto.CurrencyDto;
import ru.skillbox.currency.exchange.entity.Currency;
import ru.skillbox.currency.exchange.incoming.UpdaterCurrencies;
import ru.skillbox.currency.exchange.mapper.CurrencyMapper;
import ru.skillbox.currency.exchange.repository.CurrencyRepository;
import java.util.HashSet;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Repository
public class StorageManagement implements ApplicationStorage {

    @Autowired
    private final CurrencyMapper mapper;

    @Autowired
    private final JdbcTemplate template;

    @Autowired
    private final UpdaterCurrencies currentCurrency;

    @Autowired
    private final CurrencyRepository repository;

    @Override
    public CurrencyDto getById(Long id) {
        log.debug("StorageManagement: Initial method 'getById' at time : {}.", System.currentTimeMillis());
        return mapper.convertToDto(repository.findById(id).
                orElseThrow(() -> new RuntimeException("Currency not found with id: " + id)));
    }

    @Override
    public Double convertValue(Long value, Long numCode) {
        log.debug("StorageManagement: Initial method 'convertValue' at time : {}.", System.currentTimeMillis());
        Currency currency = repository.findByIsoNumCode(numCode);
        return value * currency.getValue();
    }

    @Override
    public CurrencyDto create(CurrencyDto dto) {
        log.debug("StorageManagement: Initial method 'create' at time : {}.", System.currentTimeMillis());
        return mapper.convertToDto(repository.save(mapper.convertToEntity(dto)));
    }

    @Override
    public List<CurrencyDto> getAll() {
        log.debug("StorageManagement: Initial method 'getAll' at time : {}.", System.currentTimeMillis());
        return repository.findAll().stream().map(mapper::convertToDto).toList();
    }

    @Override
    public void updateCurrency(CurrencyDto dto) {
        log.debug("StorageManagement: Initial method 'updateCurrency' at time : {}.", System.currentTimeMillis());
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

    @Override
    public void updateCurrenciesInDb() {
        log.debug("StorageManagement: Initial method 'updateCurrenciesInDb' at time : {}.", System.currentTimeMillis());
        HashSet<CurrencyDto> currencyDtoList = new HashSet<>(getAll());
        HashSet<Long> isoNumCodes = new HashSet<>();
        HashSet<Long> currenciesId = new HashSet<>();

        for (CurrencyDto currency : currencyDtoList) {
            isoNumCodes.add(currency.getIsoNumCode());
            currenciesId.add(currency.getId());
        }
        for (CurrencyDto dto : currentCurrency.updatedCurrency()) {
            if (isoNumCodes.contains(dto.getIsoNumCode()) || currenciesId.contains(dto.getId())) {
                dto.setId(repository.findByIsoNumCode(dto.getIsoNumCode()).getId());
                updateCurrency(dto);
            } else {
                create(dto);
            }
        }
        log.info("\nUpdate successful! At time: {}\n", System.currentTimeMillis());
    }
}
