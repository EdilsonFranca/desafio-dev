package com.br.bycoders.dtos;

import com.br.bycoders.models.Movement;
import com.br.bycoders.models.Type;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class MovementDto {
    private long id;
    private Type type;
    private String date;
    private BigDecimal value;
    private String cpf;
    private String card;
    private String hour;
    private String store;
    private String owner;

    public MovementDto() {}

    public MovementDto(Movement movement) {
        this.id   = movement.getId();
        this.type = movement.getType();
        this.date = movement.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.value = movement.getValue();
        this.cpf = movement.getCpf();
        this.card = movement.getCard();
        this.hour = movement.getHour();
        this.store = movement.getStore();
        this.owner = movement.getOwner();
    }
}
