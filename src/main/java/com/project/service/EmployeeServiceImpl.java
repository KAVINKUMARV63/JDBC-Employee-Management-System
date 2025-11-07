package com.project.service;

import java.util.List;
import com.project.dao.EmployeeDao;
import com.project.dao.EmployeeDaoImpl;
import com.project.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao dao = new EmployeeDaoImpl();

    @Override
    public boolean addEmployee(Employee emp) {
        return dao.addEmployee(emp);
    }

    @Override
    public boolean updateEmployee(Employee emp) {
        return dao.updateEmployee(emp);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return dao.deleteEmployee(id);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return dao.getEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }
}

