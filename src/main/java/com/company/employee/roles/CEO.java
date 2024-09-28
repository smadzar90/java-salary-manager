package com.company.employee.roles;

import com.company.employee.Employee;

public class CEO extends Employee {
    private static final int BONUS_AMOUNT = 7000;
    private final int avgStockPrice;

    public CEO(String firstName, String lastName, String dateOfBirth, int avgStockPrice) {
        super(firstName, lastName, dateOfBirth);
        this.avgStockPrice = avgStockPrice;
        calculateSalary();
    }

    @Override
    public void calculateSalary() {
        int baseSalary = 140000;
        int stockBonus = avgStockPrice * 100;
        int calculatedSalary = baseSalary + stockBonus + BONUS_AMOUNT;
        super.setSalary(calculatedSalary);
    }

    @Override
    public int getSalary() {
        return super.salary;
    }
}
