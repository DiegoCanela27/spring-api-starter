package com.codewithmosh.store.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateCartItemRequest {
    @NotNull(message = "Se debe especficar una cantidad.")
    @Min(value = 1, message = "Debe ser mayor que cero.")
    @Max(value = 1000, message = "Debe ser maximo 1000.")
    private Integer quantity;
}
