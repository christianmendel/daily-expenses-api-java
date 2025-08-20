package com.dailyexpenses.daily_expenses.contract.request;

import jakarta.validation.constraints.NotBlank;

public class UserRequest {
    @NotBlank(message = "Nome é obrigatório")
    public String userName;

    @NotBlank(message = "Senha é obrigatória")
    public String password;
}
