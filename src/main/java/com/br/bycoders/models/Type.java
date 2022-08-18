package com.br.bycoders.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tb_type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cod;
    private String description;
    private String nature;

    public Type(int cod) {
        this.cod = cod;
    }
}
