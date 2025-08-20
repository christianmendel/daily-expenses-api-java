package com.dailyexpenses.daily_expenses.contract.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SpentRequest {
    @NotBlank(message = "Descrição é obrigatória")
    public String description;

    @NotNull(message = "Valor é obrigatório")
    public Double value;

    @NotNull(message = "Categoria é obrigatória")
    public Integer category;

    @NotNull(message = "Tipo é obrigatório")
    public Integer type;

    @NotNull(message = "ID do usuário é obrigatório")
    public Long user;
}
