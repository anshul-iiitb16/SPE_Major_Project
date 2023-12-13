package net.spemajor.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.spemajor.springboot.exception.ResourceNotFoundException;
import net.spemajor.springboot.model.Employee;
import net.spemajor.springboot.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

// Through this *, any client can access the REST API endpoint
@CrossOrigin("*")
// Now this class becomes capable of taking http requests
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController 
{
    private static final Logger logger =
            LogManager.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees()
    {
        logger.info("Fetching the list of employees from database");
        return employeeRepository.findAll();
    }

    //BUILD CREATE EMPLOYEE REST API
    // @RequestBody will convert json to java object
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee)
    {
        logger.debug("Employee added");
        return employeeRepository.save(employee);
    }

    //BUILD GET EMPLOYEE BY ID REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeId(@PathVariable long id){
        Employee employee=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id "+id)) ;
        logger.debug("Employee found");
        return ResponseEntity.ok(employee);
    }

    //BUILD UPDATE EMPLOYEE REST API
    @PutMapping("{id}")
    //post mapping vs put mapping. post used to create a resource and put used to update a resource 
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id "+id));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        logger.debug("Successfully updated the employee");

        return ResponseEntity.ok(updateEmployee);
    }

    //BUILD DELETE EMPLOYEE REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exists "+id));

        employeeRepository.delete(employee);
        logger.debug("Delete employee");
        return new ResponseEntity<>(HttpStatus. NO_CONTENT);

    }
}
