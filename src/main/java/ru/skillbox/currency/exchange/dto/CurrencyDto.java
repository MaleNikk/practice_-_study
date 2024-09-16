package ru.skillbox.currency.exchange.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "Valute")
public class CurrencyDto implements Serializable{

    private Long id;

    @JacksonXmlProperty(localName = "ID", isAttribute = true)
    private String valuteId;

    @JacksonXmlProperty(localName = "NumCode")
    private Long isoNumCode;

    @JacksonXmlProperty(localName = "CharCode")
    private String isoCharCode;

    @JacksonXmlProperty(localName = "Nominal")
    private Long nominal;

    @JacksonXmlProperty(localName = "Name")
    private String name;

    @JacksonXmlProperty(localName = "Value")
    private Double value;

    @JacksonXmlProperty(localName = "VunitRate")
    private Double VUnitRate;

}