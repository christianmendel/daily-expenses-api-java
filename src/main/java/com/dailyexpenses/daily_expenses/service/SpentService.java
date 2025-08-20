package com.dailyexpenses.daily_expenses.service;

import com.dailyexpenses.daily_expenses.contract.request.SpentRequest;
import com.dailyexpenses.daily_expenses.contract.response.SpentResponse;
import com.dailyexpenses.daily_expenses.mapper.SpentMapper;
import com.dailyexpenses.daily_expenses.model.Spent;
import com.dailyexpenses.daily_expenses.model.User;
import com.dailyexpenses.daily_expenses.repository.SpentRepository;
import com.dailyexpenses.daily_expenses.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpentService {

    @Autowired
    SpentRepository spentRepository;

    @Transactional
    public SpentResponse create(SpentRequest request, User user) {

        Spent spent = SpentMapper.dtoMapper(request);

        if(user.getId() == null) {
            throw new RuntimeException("Usuario não encontrado");
        }

        spent.setUser(user);

        return SpentMapper.viewMapper(spentRepository.save(spent));
    }
}
