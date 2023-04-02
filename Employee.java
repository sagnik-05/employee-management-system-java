public class Employee {
    private String name;
    private double salary;
    private double taxRate;
    private double niRate;
    private double taxPaid;

    public Employee(String name, double salary, double taxRate, double niRate) {
        this.name = name;
        this.salary = salary;
        this.taxRate = taxRate;
        this.niRate = niRate;
        this.taxPaid = 0;
    }

    public double calculateTax() {
        double annualSalary = salary * 12;
        double annualTax = annualSalary * (taxRate / 100);
        taxPaid += annualTax;
        return annualTax;
    }
    public double getTaxPaid() {
        return taxPaid;
    }
    public double getNetPay() {
        double taxableIncome = salary - (salary * niRate);
        double tax = taxableIncome * taxRate;
        double netPay = salary - tax;
        return netPay;
    }

    public double getGrossPay() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Name: " + name + ", Gross Pay: " + getGrossPay() + ", Net Pay: " + getNetPay();
    }
}

// This code defines two classes, Employee and PayrollSystem. The Employee class stores information about an individual employee, including their name, salary, tax rate, and national insurance (NI) rate. The PayrollSystem class manages a list of employees and provides methods for adding employees, finding employees by name, and displaying pay slips for individual employees.

// The displayPaySlip method takes an employee's name as an argument and prints out a formatted string displaying their name, gross pay, and net pay. The net pay is calculated by subtracting the tax and NI from the employee's salary.

// The main method demonstrates how you could use the PayrollSystem class to add employees and display their pay slips.

// Note that this is just a basic example and doesn't cover all possible use cases or edge cases. It's important to thoroughly test any code you write and handle any errors or exceptions that may occur.




