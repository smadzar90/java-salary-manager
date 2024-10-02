package com.company.salary;

import com.company.employee.*;
import com.company.employee.roles.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
            if(employee != null) {
                totalSalary += employee.getSalary();
                addSalaryToEmployee(employee);
                employees.add(employee);
            }
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
        Path filePath = Path.of("src/main/java/com/company/files/employees.txt");

        try {
            String sampleData = Files.readString(filePath);
            SalaryManager sm = new SalaryManager(sampleData);
            sm.printCompanyInfo();
        } catch (IOException e) {
            System.out.println("The file could not be found!");
        }
    }
}
