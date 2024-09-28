package com.company.employee.roles;

import com.company.employee.Employee;

public class Analyst extends Employee {
    private static final int BONUS_AMOUNT = 3000;
    private final int pCount;

    public Analyst(String firstName, String lastName, String dateOfBirth, int pCount) {
        super(firstName, lastName, dateOfBirth);
        this.pCount = pCount;
        calculateSalary();
    }

    @Override
    public void calculateSalary() {
        int baseSalary = 90000;
        int projectBonus = (pCount * 1500);
        int calculatedSalary = baseSalary + projectBonus + BONUS_AMOUNT;
        super.setSalary(calculatedSalary);
    }

    @Override
    public int getSalary() {
        return super.salary;
    }
}
