package com.project.service;

import java.util.List;
import com.project.model.Employee;

public interface EmployeeService {
    boolean addEmployee(Employee emp);
    boolean updateEmployee(Employee emp);
    boolean deleteEmployee(int id);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
}
