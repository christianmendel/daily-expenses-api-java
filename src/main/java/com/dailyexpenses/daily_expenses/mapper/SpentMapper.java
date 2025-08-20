package com.dailyexpenses.daily_expenses.mapper;

import com.dailyexpenses.daily_expenses.contract.request.SpentRequest;
import com.dailyexpenses.daily_expenses.contract.request.UserRequest;
import com.dailyexpenses.daily_expenses.contract.response.SpentResponse;
import com.dailyexpenses.daily_expenses.contract.response.TokenResponse;
import com.dailyexpenses.daily_expenses.enums.SpentCategory;
import com.dailyexpenses.daily_expenses.enums.SpentType;
import com.dailyexpenses.daily_expenses.model.Spent;
import com.dailyexpenses.daily_expenses.model.Token;
import com.dailyexpenses.daily_expenses.model.User;

public class SpentMapper {
    public  static Spent dtoMapper(SpentRequest request) {
        return new Spent(request.description, request.value, SpentCategory.validateValue(request.category), SpentType.validateValue(request.type));
    }

    public  static SpentResponse viewMapper(Spent dto) {
        SpentResponse response = new SpentResponse();
        response.id = dto.getId();
        response.description = dto.getDescription();
        response.value = dto.getValue();
        response.category = dto.getCategory();
        response.type = dto.getType();

        return response;
    }
}
