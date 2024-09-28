package com.company.employee;

import com.company.salary.SalaryManager;

public abstract class Employee implements IEmployee {
    private final String firstName;
    private final String lastName;
    private final String dateOfBirth;
    protected int salary;

    public Employee(String firstName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public abstract int getSalary();
    public abstract void calculateSalary();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " +
               getFirstName() + " " +
               getLastName() + " - " +
               SalaryManager.formatToCurrency(getSalary());
    }
}
