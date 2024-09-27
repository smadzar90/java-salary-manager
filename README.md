### Description

A simple Java application designed to efficiently calculate and manage employee salaries based on their distinct roles and attributes. The application processes employee data in a structured format, and computes company salaries. Utilizing OOP principles, the system promotes reusability and maintainability in its architecture.

### Project Structure

```
com.mycompany
├── employee                        
│   ├── Employee.java                 // Abstract class representing a generic employee
│   ├── IEmployee.java                // Interface defining employee methods
│   ├── Factory.java                  // Factory design pattern for creating Employee instances
│   ├── Position.java                 // Enum representing employee positions
│   └── roles                      
│       ├── Programmer.java           // Concrete class representing a programmer
│       ├── Manager.java              // Concrete class representing a manager
│       ├── Analyst.java              // Concrete class representing an analyst
│       └── CEO.java                  // Concrete class representing a CEO
└── salary                          
    ├── SalaryManager.java            // Class responsible for managing salaries and reporting

```

