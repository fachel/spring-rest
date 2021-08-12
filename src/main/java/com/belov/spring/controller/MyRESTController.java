package com.belov.spring.controller;


import com.belov.spring.entity.Employee;
import com.belov.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> employeeList = employeeService.getAllEmployees();
        return employeeList;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable ("id") int id){
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "employee with id = " + id + " was deleted";
    }
}
