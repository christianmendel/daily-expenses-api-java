package com.dailyexpenses.daily_expenses.controller;

import com.dailyexpenses.daily_expenses.contract.request.SignInRequest;
import com.dailyexpenses.daily_expenses.contract.response.TokenResponse;
import com.dailyexpenses.daily_expenses.model.Token;
import com.dailyexpenses.daily_expenses.service.AuthService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController  {

    @Autowired
    AuthService service;

    @PostMapping("/signin")
    public TokenResponse signIn(@RequestBody SignInRequest request) {
        System.out.println("credentials = " + request);

        var token = service.signIn(request);

        if (token == null) throw new RuntimeException("Invalid client request!");
        return token;
    }

    @PutMapping("/refresh/{findByUserName}")
    public TokenResponse refreshToken(
            @PathVariable("findByUserName") String findByUserName,
            @RequestHeader("Authorization") String refreshToken) {

        if (parametersAreInvalid(findByUserName, refreshToken)) throw new RuntimeException("Invalid client request!");

        var token = service.refreshToken(findByUserName, refreshToken);
        if (token == null) ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request!");
        return  token;
    }

    private boolean parametersAreInvalid(String findByUserName, String refreshToken) {
        return StringUtils.isBlank(findByUserName) || StringUtils.isBlank(refreshToken);
    }
}

