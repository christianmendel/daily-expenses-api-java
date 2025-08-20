package com.dailyexpenses.daily_expenses.mapper;

import com.dailyexpenses.daily_expenses.contract.request.UserRequest;
import com.dailyexpenses.daily_expenses.model.User;

public class UserMapper {
    public  static User dtoMapper(UserRequest request) {
        return  new User(request.userName, request.password, true, true, true, true);
    }
}
