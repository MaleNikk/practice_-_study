package ru.skillbox.currency.exchange.incoming;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.skillbox.currency.exchange.dto.CurrencyDto;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Slf4j
public class CurrencyLoader implements UpdaterCurrencies {

    @Value("${app.update.url}")
    private String url;

    @Override
    public List<CurrencyDto> updatedCurrency() {
        log.debug("Create list new currencies at time: {}", System.currentTimeMillis());
        List<CurrencyDto> currencies = new ArrayList<>();
        XmlMapper mapper = new XmlMapper();
        for ( String xml : newCurrencies() ){
            try {
                currencies.add(mapper.readValue(xml, CurrencyDto.class));
            } catch (JsonProcessingException exception) {
                throw new RuntimeException(exception);
            }
        }
        return currencies;
    }

    private List<String> newCurrencies() {
        log.info("Load data from url at time: {}", System.currentTimeMillis());
        List<String> currencies = new ArrayList<>();
        try {
            URI uri = new URI(url);
            Scanner scanner = new Scanner(uri.toURL().openConnection().getInputStream()).useDelimiter("\n");
            if (scanner.hasNext()) {
                for (String out : scanner.next().split("<Valute ID")) {
                    if (out.contains("NumCode")) {
                        currencies.add("<Valute ID".concat(out).replace(',','.'));
                    }
                }
            }
        } catch (IOException | URISyntaxException exception) {
            System.out.println(MessageFormat.format("Income data null : {0}", exception));
            throw new RuntimeException(exception);
        }
        return currencies;
    }

}
