package com.dailyexpenses.daily_expenses.enums;

public enum SpentCategory {
    GROCERIES(1),
    RENT(2),
    UTILITIES(3),
    TRANSPORTATION(4),
    ENTERTAINMENT(5),
    DINING_OUT(6),
    HEALTHCARE(7),
    CLOTHING(8),
    EDUCATION(9),
    INSURANCE(10),
    SUBSCRIPTIONS(11),
    TRAVEL(12),
    DEBT_PAYMENT(13),
    SALARY(14),
    BUSINESS(15),
    FREELANCE(16),
    INVESTMENTS(17),
    GIFT(18),
    OTHER(99);

    private final int value;

    SpentCategory(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Integer validateValue(Integer value) {
        for (SpentCategory type : SpentCategory.values()) {
            if (type.getValue() == value) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid SpentCategory value: " + value);
    }
}
