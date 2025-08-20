package com.dailyexpenses.daily_expenses.mapper;

import com.dailyexpenses.daily_expenses.contract.request.SpentRequest;
import com.dailyexpenses.daily_expenses.contract.response.TokenResponse;
import com.dailyexpenses.daily_expenses.enums.SpentCategory;
import com.dailyexpenses.daily_expenses.enums.SpentType;
import com.dailyexpenses.daily_expenses.model.Spent;
import com.dailyexpenses.daily_expenses.model.Token;

public class TokenMapper {
    public  static TokenResponse viewMapper(Token dto) {
        TokenResponse response = new TokenResponse();
        response.userName = dto.getUserName();
        response.b = dto.isB();
        response.now = dto.getNow();
        response.validity = dto.getValidity();
        response.accessToken = dto.getAccessToken();
        response.refreshToken = dto.getRefreshToken();
        return response;
    }
}
