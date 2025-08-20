package com.dailyexpenses.daily_expenses.service;

import com.dailyexpenses.daily_expenses.contract.request.UserRequest;
import com.dailyexpenses.daily_expenses.mapper.UserMapper;
import com.dailyexpenses.daily_expenses.model.User;
import com.dailyexpenses.daily_expenses.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService  implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    @Transactional
    public void create (UserRequest request) {
        User user = UserMapper.dtoMapper(request);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        var user = userRepository.findByUserName(userName);
        if (user != null) {
            return (UserDetails) user;
        } else {
            throw new UsernameNotFoundException("userName " + userName + " not found");
        }

    }
}
