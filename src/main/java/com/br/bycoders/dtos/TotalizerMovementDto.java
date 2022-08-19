package com.br.bycoders.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.List;

public class TotalizerMovementDto {
    @JsonFormat
    private List<MovementDto> movements;
    @JsonFormat
    private BigDecimal totalizer;

    public TotalizerMovementDto(List<MovementDto> movement) {
        this.movements = movement;
        this.totalizer = calculateTotalizer(movement);
    }

    private BigDecimal calculateTotalizer(List<MovementDto> movements) {
        BigDecimal count = BigDecimal.ZERO;

        for (MovementDto movement : movements) {
            count = calculate(count, movement);
        }

        return count;
    }

    private static BigDecimal calculate(BigDecimal count, MovementDto movement) {
        return (is_Input(movement)) ? count.add(movement.getValue())
                                    : count.subtract(movement.getValue());
    }

    private static boolean is_Input(MovementDto movement) {
        return movement.getType().getNature().equals("Entrada");
    }
}