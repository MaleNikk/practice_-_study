package ru.skillbox.currency.exchange.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "create_sequence", allocationSize = 0)
    @Column(name = "id")
    private Long id;

    @Column(name = "valute_id")
    private String valuteId;

    @Column(name = "iso_num_code")
    private Long isoNumCode;

    @Column(name = "iso_char_code")
    private String isoCharCode;

    @Column(name = "nominal")
    private Long nominal;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Double value;

    @Column(name = "v_unit_rate")
    private Double VUnitRate;
}
