package com.company.employee;

import com.company.employee.roles.Analyst;
import com.company.employee.roles.CEO;
import com.company.employee.roles.Manager;
import com.company.employee.roles.Programmer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Factory {
    public static Employee createEmployee(String firstName, String lastName, String dob, String position, String details) {
        Pattern patProgrammer = Pattern.compile("\\w+=(?<locpd>\\d+),\\s\\w+=(?<yoe>\\d+),\\s\\w+=(?<iq>\\d+)", Pattern.COMMENTS);
        Pattern patAnalyst = Pattern.compile("\\w+=(?<pCount>\\d+)", Pattern.COMMENTS);
        Pattern patManager = Pattern.compile("\\w+=(?<orgSize>\\d+),\\s\\w+=(?<dr>\\d+)", Pattern.COMMENTS);
        Pattern patCEO = Pattern.compile("\\w+=(?<avgStock>\\d+)", Pattern.COMMENTS);

        return switch (position) {
            case "Programmer" -> setUpProgrammer(patProgrammer, firstName, lastName, dob, details);
            case "Analyst" -> setUpAnalyst(patAnalyst, firstName, lastName, dob, details);
            case "Manager" -> setUpManager(patManager, firstName, lastName, dob, details);
            case "CEO" -> setUpCEO(patCEO, firstName, lastName, dob, details);
            default -> null;
        };
    }

    private static Employee setUpProgrammer(Pattern patProgrammer, String firstName, String lastName, String dob, String details) {
        Matcher pMat = patProgrammer.matcher(details);
        Employee programmer = null;

        if(pMat.find()) {
            int locpd = Integer.parseInt(pMat.group("locpd"));
            int yoe = Integer.parseInt(pMat.group("yoe"));
            int iq = Integer.parseInt(pMat.group("iq"));
            programmer = new Programmer(firstName, lastName, dob, locpd, yoe, iq);
        }
        return programmer;
    }

    private static Employee setUpAnalyst(Pattern patAnalyst, String firstName, String lastName, String dob, String details) {
        Matcher aMat = patAnalyst.matcher(details);
        Employee analyst = null;

        if(aMat.find()) {
            int projectCount = Integer.parseInt(aMat.group("pCount"));
            analyst = new Analyst(firstName, lastName, dob, projectCount);
        }
        return analyst;
    }

    private static Employee setUpManager(Pattern patManager, String firstName, String lastName, String dob, String details) {
        Matcher pMat = patManager.matcher(details);
        Employee manager = null;

        if(pMat.find()) {
            int orgSize = Integer.parseInt(pMat.group("orgSize"));
            int directReports = Integer.parseInt(pMat.group("dr"));
            manager = new Manager(firstName, lastName, dob, orgSize, directReports);
        }
        return manager;
    }

    private static Employee setUpCEO(Pattern patCEO, String firstName, String lastName, String dob, String details) {
        Matcher pMat = patCEO.matcher(details);
        Employee ceo = null;

        if(pMat.find()) {
            int avgStockPrice = Integer.parseInt(pMat.group("avgStock"));
            ceo = new CEO(firstName, lastName, dob, avgStockPrice);
        }
        return ceo;
    }
}
