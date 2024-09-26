package com.mycompany;

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
        int baseSalary = 65000;
        int calculatedSalary = baseSalary + (orgSize * directReports * 3) + BONUS_AMOUNT;
        super.setSalary(calculatedSalary);
    }

    @Override
    public int getSalary() {
        return super.salary;
    }
}
