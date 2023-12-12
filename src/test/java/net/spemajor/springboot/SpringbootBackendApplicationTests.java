package net.spemajor;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import net.spemajor.springboot.SpringbootBackendApplication;
import net.spemajor.springboot.controller.EmployeeController;
import net.spemajor.springboot.model.Employee;
import net.spemajor.springboot.repository.EmployeeRepository;

@SpringBootTest(classes = SpringbootBackendApplication.class)
// @WebMvcTest(SubmissionController.class)
@AutoConfigureMockMvc
public class SpringbootBackendApplicationTests {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeController employeeController;

    // Initialize mocks
    public void EmployeeControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        // Mock data
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setFirstName("John");
        employee1.setLastName("Doe");
        employee1.setEmailId("john.doe@example.com");

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setFirstName("Jane");
        employee2.setLastName("Doe");
        employee2.setEmailId("jane.doe@example.com");

        List<Employee> mockEmployeeList = Arrays.asList(employee1, employee2);

        // Mock the behavior of the employeeRepository
        when(employeeRepository.findAll()).thenReturn(mockEmployeeList);

        // Call the controller method
        List<Employee> result = employeeController.getAllEmployees();

        // Verify the result
        assertEquals(mockEmployeeList.size(), result.size());
        assertEquals(mockEmployeeList.get(0).getFirstName(), result.get(0).getFirstName());
        assertEquals(mockEmployeeList.get(1).getEmailId(), result.get(1).getEmailId());
        // Add more assertions as needed
    
	}
}
