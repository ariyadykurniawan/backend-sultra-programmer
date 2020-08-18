package com.example.demosultraprogrammer.service;

import com.example.demosultraprogrammer.entity.Employee;
import com.example.demosultraprogrammer.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        return employee;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee employeeCreated = employeeRepository.save(employee);
        return employeeCreated;
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        employee.setId(id);
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> searchEmployeeByName(String name) {
        List<Employee> employees = employeeRepository.findByNameLike(name);
        return employees;
    }
}
