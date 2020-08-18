package com.example.demosultraprogrammer.repository;

import com.example.demosultraprogrammer.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameLike(String name);
}
