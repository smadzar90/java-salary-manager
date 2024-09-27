package com.company.salary;

import com.company.employee.*;
import com.company.employee.roles.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalaryManager {
    private final String workers;
    private int totalSalary;
    private int totalProgrammersSalary;
    private int totalAnalystsSalary;
    private int totalManagersSalary;
    private int totalCeosSalary;
    private final List<Employee> employees;

    public SalaryManager(String workers) {
        this.workers = workers;
        this.totalSalary = 0;
        this.totalProgrammersSalary = 0;
        this.totalAnalystsSalary = 0;
        this.totalManagersSalary = 0;
        this.totalCeosSalary = 0;
        this.employees = new ArrayList<>();
        computeCompanySalaries();
    }

    public void computeCompanySalaries() {
        String workersRegex = """
        (?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{4}-\\d{1,2}-\\d{1,2}).*,\\s(?<position>\\w+),\\s\\{(?<details>.*)}\\n
        """;

        Pattern pat = Pattern.compile(workersRegex, Pattern.COMMENTS);
        Matcher mat = pat.matcher(workers);

        while(mat.find()) {
            Employee employee = Factory.createEmployee(mat.group("firstName"), mat.group("lastName"), mat.group("dob"),
                    mat.group("position"), mat.group("details"));
            assert employee != null;
            totalSalary += employee.getSalary();
            addSalaryToEmployee(employee);
            employees.add(employee);
        }
    }

    private void addSalaryToEmployee(Employee employee) {
        if(employee instanceof Programmer) {
            totalProgrammersSalary += employee.getSalary();
        } else if(employee instanceof Analyst) {
            totalAnalystsSalary += employee.getSalary();
        } else if(employee instanceof Manager) {
            totalManagersSalary += employee.getSalary();
        } else if(employee instanceof CEO) {
            totalCeosSalary += employee.getSalary();
        }
    }

    public void printEmployeeSalaries() {
        for(Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static String formatToCurrency(int salary) {
        return NumberFormat.getCurrencyInstance().format(salary);
    }

    public void printTotalSalary() {
        System.out.printf("Total company salaries: %s\n", NumberFormat.getCurrencyInstance().format(totalSalary));
    }

    public void printSalariesByEmployee(Position position) {
        String format = "Total %s salaries: %s\n";
        switch (position) {
            case PROGRAMMER ->
                System.out.printf(format, "programmers", formatToCurrency(totalProgrammersSalary));
            case ANALYST ->
                System.out.printf(format, "analysts", formatToCurrency(totalAnalystsSalary));
            case MANAGER ->
                System.out.printf(format, "managers", formatToCurrency(totalManagersSalary));
            case CEO ->
                System.out.printf(format, "CEO's", formatToCurrency(totalCeosSalary));
        }
    }

    /*
        Calculates total salary company need to distribute
        Groups salaries based on positions
        Outputs salary by each worker
     */
    public void printCompanyInfo() {
        System.out.println("\nCOMPANY SALARIES\n");
        printTotalSalary();
        printSalariesByEmployee(Position.PROGRAMMER);
        printSalariesByEmployee(Position.ANALYST);
        printSalariesByEmployee(Position.MANAGER);
        printSalariesByEmployee(Position.CEO);
        System.out.println("\nAll employees:\n");
        printEmployeeSalaries();
    }

    public static void main(String[] args) {
        //LastName, FirstName, DOB, Position, {Details}
        String sampleData = """
                Flinstone, Fred, 1900-01-01, Programmer, {locpd=2000, yoe=10, iq=140}
                Rubble, Barney, 1905-02-02, Manager, {orgSize=100, dr=10}
                Flinstone, Wilma, 1910-03-03, Analyst, {projectCount=5}
                Genert, Wilma, 1910-03-03, CEO, {avgStockPrice=300}
                Smith, Alice, 1985-05-15, Programmer, {locpd=2500, yoe=5, iq=130}
                Johnson, Bob, 1990-08-22, Programmer, {locpd=2200, yoe=3, iq=125}
                Lee, Charlie, 1992-12-30, Programmer, {locpd=1800, yoe=2, iq=120}
                Brown, David, 1980-11-11, Manager, {orgSize=150, dr=12}
                Miller, Emma, 1988-04-04, Manager, {orgSize=200, dr=15}
                Davis, Fiona, 1995-09-09, Analyst, {projectCount=8}
                Wilson, George, 1982-01-20, Analyst, {projectCount=10}
                Taylor, Hannah, 1975-06-06, CEO, {avgStockPrice=500}
                Anderson, Ian, 1960-03-03, CEO, {avgStockPrice=450}
            """;
        SalaryManager sm = new SalaryManager(sampleData);
        sm.printCompanyInfo();
    }
}
