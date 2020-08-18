package com.example.demosultraprogrammer.controller;

import com.example.demosultraprogrammer.entity.Employee;
import com.example.demosultraprogrammer.model.Response;
import com.example.demosultraprogrammer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1.0")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    private ResponseEntity getEmployees(){
        Response bodyResponse = new Response(HttpStatus.OK.value(), Response.MESSAGE_SUCCSESS, employeeService.getEmployees());
        return ResponseEntity.ok(bodyResponse);
    }

    @GetMapping("/employee/{id}")
    private ResponseEntity getEmployee(@PathVariable Long id){
        try{
            Response bodyResponse = new Response(HttpStatus.OK.value(), Response.MESSAGE_SUCCSESS, employeeService.getEmployee(id));
            return ResponseEntity.ok(bodyResponse);
        }catch (NoSuchElementException e){
            Response bodyResponse = new Response(HttpStatus.NOT_FOUND.value(), "Data tidak ditemukan");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyResponse);
        }
    }

    @PostMapping(value = "/employee", consumes = "application/json")
    private ResponseEntity createEmployee(@RequestBody Employee employee){
        Response bodyResponse = new Response(HttpStatus.OK.value(), Response.MESSAGE_SUCCSESS, employeeService.createEmployee(employee));
        return ResponseEntity.ok(bodyResponse);
    }

    @PutMapping(value = "/employee/{id}")
    private ResponseEntity updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        Response bodyResponse = new Response(HttpStatus.OK.value(), Response.MESSAGE_SUCCSESS, employeeService.updateEmployee(employee, id));
        return ResponseEntity.ok(bodyResponse);
    }

    @DeleteMapping(value = "/employee/{id}")
    private ResponseEntity deleteEmployee(@PathVariable Long id){
        try{
            employeeService.deleteEmployee(id);
            Response bodyResponse = new Response(HttpStatus.OK.value(), Response.MESSAGE_SUCCSESS);
            return ResponseEntity.ok(bodyResponse);
        }catch (EmptyResultDataAccessException e){
            Response bodyResponse = new Response(HttpStatus.NOT_FOUND.value(), "Tidak berhasil mengahpus data, data tidak di temukan");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyResponse);
        }
    }

    @GetMapping(value = "/employee/search")
    private ResponseEntity searchEmplpyee(@RequestParam String name){
        Response responseBody = new Response(HttpStatus.OK.value(), Response.MESSAGE_SUCCSESS, employeeService.searchEmployeeByName(name));
        return ResponseEntity.ok(responseBody);
    }

}
