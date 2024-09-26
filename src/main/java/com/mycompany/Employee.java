package com.mycompany;

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public abstract int getSalary();
    public abstract void calculateSalary();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
               "firstName='" + getFirstName() + '\'' +
               ", lastName='" + getLastName() + '\'' +
               ", dateOfBirth='" + getDateOfBirth() + '\'' +
               ", salary=" + getSalary() +
               '}';
    }
}
