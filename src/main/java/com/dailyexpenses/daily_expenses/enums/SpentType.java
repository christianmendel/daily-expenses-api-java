package com.dailyexpenses.daily_expenses.enums;

public enum SpentType {
    SALARY(1),
    BUSINESS(2),
    FREELANCE(3),
    INVESTMENTS(4),
    GIFT(5),
    OTHER_INCOME(6);

    private final int value;

    SpentType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Integer validateValue(Integer value) {
        for (SpentType type : SpentType.values()) {
            if (type.getValue() == value) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid SpentType value: " + value);
    }
}
