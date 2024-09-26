package com.mycompany;

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
        int baseSalary = 65000;
        int calculatedSalary = baseSalary + (locpd * yoe * iq) / 100 + BONUS_AMOUNT;
        super.setSalary(calculatedSalary);
    }

    @Override
    public int getSalary() {
        return this.salary;
    }
}
