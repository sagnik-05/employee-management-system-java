import java.util.*;
import java.io.*;

public class PayrollSystem {
    private List<Employee> employees = new ArrayList<>();
    private final String FILENAME = "employees.txt";

    public PayrollSystem() {
        employees = new ArrayList<Employee>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void deleteEmployee(String name) {
        boolean removed = false;
        Iterator<Employee> iter = employees.iterator();
        while (iter.hasNext()) {
            Employee employee = iter.next();
            if (employee.getName().equals(name)) {
                iter.remove();
                System.out.println("Employee " + name + " has been removed.");
                removed = true;
            }
        }
        if (!removed) {
            System.out.println("Employee " + name + " not found.");
            return;
        }
        List<String> temp = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (!tokens[0].equals(name)) {
                    temp.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from " + FILENAME);
            return;
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (String line : temp) {
                writer.println(line);
            }
            System.out.println("Employee details saved to " + FILENAME);
        } catch (IOException e) {
            System.out.println("Error writing to " + FILENAME);
        }
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

    private void saveEmployeesToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Employee employee : employees) {
                writer.println(employee.getName() + "," + employee.getGrossPay() + "," + employee.getTaxRate() + ","
                        + employee.getniRate());
            }
        } catch (IOException e) {
            System.err.println("Error saving employees to file: " + e.getMessage());
        }
    }

    private void loadEmployeesFromFile() {
        try (Scanner scanner = new Scanner(new File(FILENAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                if (fields.length == 4) {
                    String name = fields[0];
                    double salary = Double.parseDouble(fields[1]);
                    double taxRate = Double.parseDouble(fields[2]);
                    double taxPaid = Double.parseDouble(fields[3]);
                    Employee employee = new Employee(name, salary, taxRate, taxPaid);
                    employees.add(employee);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No employee data found.");
        }
    }

    public static void main(String[] args) {

        PayrollSystem payrollSystem = new PayrollSystem();
        payrollSystem.loadEmployeesFromFile();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a operation:");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Display Pay Slip");
            System.out.println("4. Save to File");
            System.out.println("5. Exit");
            System.out.println("========================================");
            System.out.println("Enter a choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("========================================");

            if (choice == 1) {
                System.out.print("Enter name of employee: ");
                String name = scanner.nextLine();
                System.out.print("Enter salary of employee: ");
                double salary = scanner.nextDouble();
                System.out.print("Enter tax rate of employee (in decimal): ");
                double taxRate = scanner.nextDouble();
                System.out.print("Enter National Insurance Rate of employee (in decimal[0.x]): ");
                double niRate = scanner.nextDouble();
                Employee employee = new Employee(name, salary, taxRate, niRate);
                payrollSystem.addEmployee(employee);
                System.out.println("Employee added successfully.");
            } else if (choice == 2) {
                System.out.print("Enter name of employee to delete: ");
                String name = scanner.nextLine();
                payrollSystem.deleteEmployee(name);
                System.out.println("Employee deleted successfully.");
            } else if (choice == 3) {
                System.out.print("Enter name of employee to display pay slip: ");
                String name = scanner.nextLine();
                System.out.println("========================================");
                payrollSystem.displayPaySlip(name);
                System.out.println("========================================");
            } else if (choice == 4) {
                payrollSystem.saveEmployeesToFile();
                System.out.println("Data saved to file.");
            } else if (choice == 5) {
                payrollSystem.saveEmployeesToFile();
                System.out.println("Data saved to file.");
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();

    }
}