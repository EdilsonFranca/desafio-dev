package com.br.bycoders.models;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "tb_movement")
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private Type type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private BigDecimal value;

    @Column(nullable = false, length = 11)
    private String cpf;
    @Column(nullable = false, length = 12)
    private String card;

    @Column(nullable = false, length = 8)
    private String hour;
    @Column(nullable = false, length = 30)
    private String store;
    @Column(nullable = false, length = 30)
    private String owner;

    public Movement() {}

    public Movement(Type type, LocalDate date, BigDecimal value, String cpf, String card, String hour, String store, String owner) {
        this.type = type;
        this.date = date;
        this.value = value;
        this.cpf = cpf;
        this.card = card;
        this.hour = hour;
        this.store = store;
        this.owner = owner;
    }
}
