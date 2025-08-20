package com.dailyexpenses.daily_expenses.service;

import com.dailyexpenses.daily_expenses.contract.request.SignInRequest;
import com.dailyexpenses.daily_expenses.contract.response.TokenResponse;
import com.dailyexpenses.daily_expenses.mapper.TokenMapper;
import com.dailyexpenses.daily_expenses.model.Token;
import com.dailyexpenses.daily_expenses.repository.UserRepository;
import com.dailyexpenses.daily_expenses.security.jwt.JwtTokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository repository;

    public TokenResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.userName,
                        request.password
                )
        );

        var user = repository.findByUserName(request.userName);

        if (user == null) {
            throw new UsernameNotFoundException("Username " + request.userName + " not found!");
        }

        var token = tokenProvider.createAccessToken(
                user.getId(),
                request.userName,
                user.getRoles()
        );

        return TokenMapper.viewMapper(token);
    }

    public TokenResponse refreshToken(String name, String refreshToken) {
        var user = repository.findByUserName(name);
        Token token;
        if (user != null) {
            token = tokenProvider.refreshToken(refreshToken);
        } else {
            throw new UsernameNotFoundException("Username " + name + " not found!");
        }
        return TokenMapper.viewMapper(token);
    }
}