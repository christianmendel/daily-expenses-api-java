package com.dailyexpenses.daily_expenses.contract.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SpentResponse {
    public Long id;
    public String description;
    public Double value;
    public Integer category;
    public Integer type;
}
