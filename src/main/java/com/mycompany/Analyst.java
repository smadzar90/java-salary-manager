package com.mycompany;

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
        int baseSalary = 55000;
        int calculatedSalary = baseSalary + (pCount * 2000) + BONUS_AMOUNT;
        super.setSalary(calculatedSalary);
    }

    @Override
    public int getSalary() {
        return super.salary;
    }
}
