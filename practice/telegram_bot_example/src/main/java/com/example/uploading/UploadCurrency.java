package com.example.uploading;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@Component
@Slf4j
@Data
public class UploadCurrency implements ImplUploadCurrency {

    private final HttpGet httpGet;
    private final ObjectMapper mapper;
    private final HttpClient httpClient;
    private final AtomicReference<Double> price = new AtomicReference<>();

    public UploadCurrency(
            @Value("${binance.api.getPrice}")
            String uri
    ) {
        httpGet = new HttpGet(uri);
        mapper = new ObjectMapper();
        httpClient = HttpClientBuilder.create()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
    }
    public Double uploadBitcoinPrice() throws IOException {
        log.info("Performing client call to binanceApi to get bitcoin price");
        try {
            return getMapper().readTree(EntityUtils.toString(getHttpClient().execute(getHttpGet()).getEntity()))
                    .path("price").asDouble();
        } catch (IOException exception) {
            log.error("Error while getting price from binance", exception);
            throw exception;
        }
    }

    public Double getBitcoinPrice() throws IOException {
        if (getPrice().get() == null) {
            getPrice().set(uploadBitcoinPrice());
        }
        return getPrice().get();
    }

}
