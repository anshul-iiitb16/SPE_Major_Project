package net.spemajor.springboot.repository;

import net.spemajor.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> 
{
    // All crud Database Methods
    // Whenever any record does not exist in the database, then our application should throw and exception
    


    
}
