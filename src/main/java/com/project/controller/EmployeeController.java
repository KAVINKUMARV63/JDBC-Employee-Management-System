package com.project.controller;

import java.util.*;
import com.project.model.Employee;
import com.project.service.EmployeeService;
import com.project.service.EmployeeServiceImpl;

public class EmployeeController {
    private static final EmployeeService service = new EmployeeServiceImpl();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee by ID");
            System.out.println("3. View All Employees");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int ch;
            try {
                ch = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine(); // clear invalid input
                continue;
            }

            // consume leftover newline (important when mixing nextInt() & nextLine())
            sc.nextLine();

            switch (ch) {
                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewById();
                    break;

                case 3:
                    viewAll();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    System.out.println("Exiting program... Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter department: ");
        String dept = sc.nextLine();
        System.out.print("Enter salary: ");
        double sal = sc.nextDouble();
        sc.nextLine(); // consume newline

        Employee emp = new Employee(0, name, dept, sal);
        boolean added = service.addEmployee(emp);

        if (added)
            System.out.println("✅ Added successfully!");
        else
            System.out.println("❌ Failed to add!");
    }

    private static void viewById() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Employee emp = service.getEmployeeById(id);
        if (emp != null)
            System.out.println(emp);
        else
            System.out.println("Employee not found!");
    }

    private static void viewAll() {
        List<Employee> list = service.getAllEmployees();
        if (list.isEmpty()) {
            System.out.println("No employees found!");
        } else {
            list.forEach(System.out::println);
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Employee emp = service.getEmployeeById(id);
        if (emp == null) {
            System.out.println("Employee not found!");
            return;
        }

        System.out.print("Enter new name: ");
        String newName = sc.nextLine();
        System.out.print("Enter new department: ");
        String newDept = sc.nextLine();
        System.out.print("Enter new salary: ");
        double newSalary = sc.nextDouble();
        sc.nextLine();

        emp.setName(newName);
        emp.setDepartment(newDept);
        emp.setSalary(newSalary);

        boolean updated = service.updateEmployee(emp);
        System.out.println(updated ? "✅ Updated!" : "❌ Failed to update!");
    }

    private static void deleteEmployee() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean deleted = service.deleteEmployee(id);
        System.out.println(deleted ? "✅ Deleted!" : "❌ Failed to delete!");
    }
}
