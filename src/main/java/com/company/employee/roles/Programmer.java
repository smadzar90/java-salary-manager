package com.company.employee.roles;

import com.company.employee.Employee;

public class Programmer extends Employee {
    private static final int BONUS_AMOUNT = 5000;
    private final int locpd;
    private final int yoe;
    private final int iq;

    public Programmer(String firstName, String lastName, String dateOfBirth, int locpd, int yoe, int iq) {
        super(firstName, lastName, dateOfBirth);
        this.locpd = locpd;
        this.yoe = yoe;
        this.iq = iq;
        calculateSalary();
    }

    @Override
    public void calculateSalary() {
        int baseSalary = 100000;
        int productivityBonus = (locpd * 5);
        int experienceBonus = 3000 * yoe;
        int performanceBonus = iq * 50;
        int calculatedSalary = baseSalary + productivityBonus + experienceBonus + performanceBonus + BONUS_AMOUNT;
        super.setSalary(calculatedSalary);
    }

    @Override
    public int getSalary() {
        return this.salary;
    }
}
