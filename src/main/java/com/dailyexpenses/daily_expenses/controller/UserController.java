package com.dailyexpenses.daily_expenses.controller;

import com.dailyexpenses.daily_expenses.contract.request.UserRequest;
import com.dailyexpenses.daily_expenses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public void create(@RequestBody UserRequest request) {
        userService.create(request);
    }
}