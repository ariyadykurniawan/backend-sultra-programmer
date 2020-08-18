package com.example.demosultraprogrammer.service;

import com.example.demosultraprogrammer.entity.Employee;

import java.util.List;
import java.util.NoSuchElementException;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee getEmployee(Long id) throws NoSuchElementException;
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee, Long id);
    void deleteEmployee(Long id);
    List<Employee> searchEmployeeByName(String name);
}
