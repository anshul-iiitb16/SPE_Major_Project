package net.spemajor.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.spemajor.springboot.model.Employee;
import net.spemajor.springboot.repository.EmployeeRepository;

import java.util.List;

// Now this class becomes capable of taking http requests
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController 
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }
}
