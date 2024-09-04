package ru.skillbox.currency.exchange.refresh.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.skillbox.currency.exchange.dto.CurrencyDto;
import java.io.*;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Slf4j
public class LoadCurrentCurrency {

    @Value("${app.update.url}")
    private String url;

    public List<CurrencyDto> updatedCurrency() {
        log.info("Build list CurrencyDto with new data at time: {}", System.currentTimeMillis());
        List<CurrencyDto> currencyDtoList = new ArrayList<>();
        String[] data = dataIncome().split("/Valute");
        for (String execute : data) {
            String[] end = execute.split("><");
            CurrencyDto currencyDto = new CurrencyDto();
            if (end.length > 5) {
                for (String enjoy : end) {
                    if (enjoy.contains("=")) {
                       String bankID = delimiter(enjoy, "=", 1).replaceAll("\"", "");
                       currencyDto.setValuteId(String.valueOf(bankID));
                    } else if (enjoy.contains(">") && enjoy.contains("<")) {
                        if (enjoy.contains("NumCode")) {
                            String numCode = delimiter(delimiter(enjoy, ">", 1), "<", 0);
                            currencyDto.setIsoNumCode(Long.valueOf(numCode));
                        }
                        if (enjoy.contains("CharCode")) {
                            String charCode = delimiter(delimiter(enjoy, ">", 1), "<", 0);
                            currencyDto.setIsoCharCode(String.valueOf(charCode));
                        }
                        if (enjoy.contains("Nominal")) {
                            String nominal = delimiter(delimiter(enjoy, ">", 1), "<", 0);
                            currencyDto.setNominal(Long.valueOf(nominal));
                        }
                        if (enjoy.contains("Name")) {
                            String name = delimiter(delimiter(enjoy, ">", 1), "<", 0);
                            currencyDto.setName(String.valueOf(name));
                        }
                        if (enjoy.contains("Value")) {
                            String value = delimiter(delimiter(enjoy, ">", 1), "<", 0);
                            currencyDto.setValue(Double.valueOf(value.replace(',','.')));
                        }
                        if (enjoy.contains("VunitRate")) {
                            String vUnitRate = delimiter(delimiter(enjoy, ">", 1), "<", 0);
                            currencyDto.setVUnitRate(Double.valueOf(vUnitRate.replace(',','.')));
                            currencyDtoList.add(currencyDto);
                        }
                    }
                }
            }
        }
        return currencyDtoList;
    }


    private String delimiter(String input, String regex, Integer index) {
        String[] data = input.split(regex);
        return data[index];
    }

    private String dataIncome() {
        log.info("Load new info from bank at time: {}", System.currentTimeMillis());
        StringBuilder builder = new StringBuilder();
        try {
            URL https = new URL(url);
            Scanner scanner = new Scanner(https.openConnection().getInputStream());
            while (scanner.hasNext()) {
                String check = scanner.next();
                if (check.contains("Name")) {
                    builder.append(check);
                }
            }
        } catch (IOException exception) {
            System.out.println(MessageFormat.format("We caught exception : {0}", exception));
            throw new RuntimeException(exception);

        }
        return builder.toString();
    }

}
