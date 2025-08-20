package com.dailyexpenses.daily_expenses.repository;

import com.dailyexpenses.daily_expenses.model.Spent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpentRepository extends JpaRepository<Spent, Long> {}