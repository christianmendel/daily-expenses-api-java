package com.dailyexpenses.daily_expenses.controller;

import com.dailyexpenses.daily_expenses.contract.request.SpentRequest;
import com.dailyexpenses.daily_expenses.contract.response.SpentResponse;
import com.dailyexpenses.daily_expenses.model.User;
import com.dailyexpenses.daily_expenses.service.SpentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/spent")
public class SpentController {

    @Autowired
    SpentService spentService;

    @PostMapping()
    public SpentResponse create(@RequestBody SpentRequest request, Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        return spentService.create(request, user);
    }
}