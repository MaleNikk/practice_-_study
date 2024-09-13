package ru.skillbox.currency.exchange.dto;

import lombok.*;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@XmlType(name = "Valute")
@XmlRootElement
public class CurrencyDto {

    private Long id;

    @XmlAttribute(name = "ID")
    private String valuteId;

    @XmlElement(name = "NumCode")
    private Long isoNumCode;

    @XmlElement(name = "CharCode")
    private String isoCharCode;

    @XmlElement(name = "Nominal")
    private Long nominal;

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Value")
    private Double value;

    @XmlElement(name = "VunitRate")
    private Double VUnitRate;

}