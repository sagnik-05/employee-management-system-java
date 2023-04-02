import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class PayrollSystem {
    private List<Employee> employees;

    public PayrollSystem() {
        employees = new ArrayList<Employee>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee findEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public void displayPaySlip(String name) {
        Employee employee = findEmployee(name);
        if (employee != null) {
            System.out.println(employee.toString());
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) {


        PayrollSystem payrollSystem = new PayrollSystem();

        Employee sagnik = new Employee("sagnik", 100000, 0.3, 0.2);
        payrollSystem.addEmployee(sagnik);

        Employee sarah = new Employee("Sarah", 60000, 0.2, 0.1);
        payrollSystem.addEmployee(sarah);

        payrollSystem.displayPaySlip("sagnik");
        payrollSystem.displayPaySlip("Sarah");

        double annualTax = sagnik.calculateTax();
        double taxPaid = sagnik.getTaxPaid();
        System.out.println("Employee " + sagnik.getName() + " paid " + taxPaid + " in taxes this year.");
    }
}

/* 
PayrollSystem payrollSystem = new PayrollSystem();

System.out.print("Enter name of first employee: ");
String name1 = scanner.nextLine();
System.out.print("Enter salary of first employee: ");
double salary1 = scanner.nextDouble();
System.out.print("Enter tax rate of first employee (in decimal): ");
double taxRate1 = scanner.nextDouble();
System.out.print("Enter tax paid of first employee: ");
double taxPaid1 = scanner.nextDouble();

Employee employee1 = new Employee(name1, salary1, taxRate1, taxPaid1);
payrollSystem.addEmployee(employee1);

scanner.nextLine();

System.out.print("Enter name of second employee: ");
String name2 = scanner.nextLine();
System.out.print("Enter salary of second employee: ");
double salary2 = scanner.nextDouble();
System.out.print("Enter tax rate of second employee (in decimal): ");
double taxRate2 = scanner.nextDouble();
System.out.print("Enter tax paid of second employee: ");
double taxPaid2 = scanner.nextDouble();

Employee employee2 = new Employee(name2, salary2, taxRate2, taxPaid2);
payrollSystem.addEmployee(employee2);

scanner.nextLine();

System.out.print("Enter name of employee to display pay slip: ");
String name = scanner.nextLine();
payrollSystem.displayPaySlip(name);

scanner.close();
}
*/