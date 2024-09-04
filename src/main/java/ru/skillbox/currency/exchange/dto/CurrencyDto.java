package ru.skillbox.currency.exchange.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class CurrencyDto {

    private Long id;

    private String valuteId;

    private Long isoNumCode;

    private String isoCharCode;

    private Long nominal;

    private String name;

    private Double value;

    private Double VUnitRate;

}