package com.dailyexpenses.daily_expenses.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="spents")
public class Spent {
    public Spent(String description, Double value, Integer category, Integer type) {
        this.description = description;
        this.value = value;
        this.category = category;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String description;

    @Column(nullable = false)
    private Double value;

    @Column(nullable = false)
    private Integer category;

    @Column(nullable = false)
    private Integer type;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Double getValue() {
        return value;
    }

    public Integer getCategory() {
        return category;
    }

    public Integer getType() {
        return type;
    }

    public User getUser() {
        return user;
    }
}
