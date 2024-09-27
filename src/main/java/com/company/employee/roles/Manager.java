package com.company.employee.roles;

import com.company.employee.Employee;

public class Manager extends Employee {
    private static final int BONUS_AMOUNT = 4000;
    private final int orgSize;
    private final int directReports;

    public Manager(String firstName, String lastName, String dateOfBirth, int orgSize, int directReports) {
        super(firstName, lastName, dateOfBirth);
        this.orgSize = orgSize;
        this.directReports = directReports;
        calculateSalary();
    }

    @Override
    public void calculateSalary() {
        int baseSalary = 120000;
        int teamBonus = orgSize * directReports * 20;
        int calculatedSalary = baseSalary + teamBonus + BONUS_AMOUNT;
        super.setSalary(calculatedSalary);
    }

    @Override
    public int getSalary() {
        return super.salary;
    }
}
