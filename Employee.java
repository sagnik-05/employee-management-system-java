import java.util.ArrayList;
public class Employee {
    private String name;
    private String address;
    private double salary;
    private double taxRate;
    private double nationalInsuranceRate;
    
    // Constructors
    public Employee(String name, String address, double salary, double taxRate, double nationalInsuranceRate) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.taxRate = taxRate;
        this.nationalInsuranceRate = nationalInsuranceRate;
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public double getTaxRate() {
        return taxRate;
    }
    
    public double getNationalInsuranceRate() {
        return nationalInsuranceRate;
    }
}

public class PaySlip {
    private String employeeName;
    private double grossPay;
    private double taxDeduction;
    private double nationalInsuranceDeduction;
    private double netPay;
    
    // Constructors
    public PaySlip(String employeeName, double grossPay, double taxDeduction, double nationalInsuranceDeduction, double netPay) {
        this.employeeName = employeeName;
        this.grossPay = grossPay;
        this.taxDeduction = taxDeduction;
        this.nationalInsuranceDeduction = nationalInsuranceDeduction;
        this.netPay = netPay;
    }
    
    // Getters and setters
    public String getEmployeeName() {
        return employeeName;
    }
    
    public double getGrossPay() {
        return grossPay;
    }
    
    public double getTaxDeduction() {
        return taxDeduction;
    }
    
    public double getNationalInsuranceDeduction() {
        return nationalInsuranceDeduction;
    }
    
    public double getNetPay() {
        return netPay;
    }
}


import java.util.ArrayList;
public class Payroll {
    private ArrayList<Employee> employees;
    
    // Constructors
    public Payroll() {
        employees = new ArrayList<>();
    }
    
    // Add an employee to the list
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    
    // Calculate the monthly pay for an employee
    public double calculateMonthlyPay(Employee employee) {
        double grossPay = employee.getSalary();
        double taxDeduction = grossPay * employee.getTaxRate();
        double nationalInsuranceDeduction = grossPay * employee.getNationalInsuranceRate();
        double netPay = grossPay - taxDeduction - nationalInsuranceDeduction;
        
        return netPay;
    }
    
    // Generate a pay slip for an employee
    public PaySlip generatePaySlip(Employee employee) {
        double grossPay = employee.getSalary();
        double taxDeduction = grossPay * employee.getTaxRate();
        double nationalInsuranceDeduction = grossPay * employee.getNationalInsuranceRate();
        double netPay = grossPay - taxDeduction - nationalInsuranceDeduction;
        PaySlip paySlip = new PaySlip(employee.getName(), grossPay, taxDeduction, nationalInsuranceDeduction, netPay);
    
        return paySlip;
    }
    
    // Generate pay slips for all employees
    public ArrayList<PaySlip> generatePaySlips() {
        ArrayList<PaySlip> paySlips = new ArrayList<>();
        
        for (Employee employee : employees) {
            PaySlip paySlip = generatePaySlip(employee);
            paySlips.add(paySlip);
        }
        
        return paySlips;
    }    

    import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Payroll payroll = new Payroll();
        
        Employee employee1 = new Employee("John Smith", "123 Main St.", 5000, 0.2, 0.1);
        Employee employee2 = new Employee("Jane Doe", "456 Elm St.", 6000, 0.2, 0.1);
        
        payroll.addEmployee(employee1);
        payroll.addEmployee(employee2);
        
        ArrayList<PaySlip> paySlips = payroll.generatePaySlips();
        
        for (PaySlip paySlip : paySlips) {
            System.out.println("Employee Name: " + paySlip.getEmployeeName());
            System.out.println("Gross Pay: " + paySlip.getGrossPay());
            System.out.println("Tax Deduction: " + paySlip.getTaxDeduction());
            System.out.println("National Insurance Deduction: " + paySlip.getNationalInsuranceDeduction());
            System.out.println("Net Pay: " + paySlip.getNetPay());
            System.out.println();
        }
    }
}
