public class Employee1{
    private String name;
    private String address;
    private double salary;
    private double taxRate;
    private double nationalInsuranceRate;
    
    // Constructors
    public Employee1(String name, String address, double salary, double taxRate, double nationalInsuranceRate) {
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