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
        int baseSalary = 90000;
        int calculatedSalary = baseSalary + (avgStockPrice * 50) + BONUS_AMOUNT;
        super.setSalary(calculatedSalary);
    }

    @Override
    public int getSalary() {
        return super.salary;
    }
}
