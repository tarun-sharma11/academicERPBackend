package com.example.academicerpbackend.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.example.academicerpbackend.Exception.ResourceNotFound;
import com.example.academicerpbackend.Model.Employee;
import com.example.academicerpbackend.Model.Login;
import com.example.academicerpbackend.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    // get all Employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        employee.setPassword(encoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFound("Employee not exists with id :"+id));
        return ResponseEntity.ok(employee);
    }

    public EmployeeController() {
    }

    @PostMapping("/employee/login")
    public ResponseEntity<Employee> loginEmployee(@RequestBody Login login){
         String depName = "Outreach";
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        Employee employee = employeeRepository.findByEmailAndDepartment_Name(login.getEmail(), depName);
        if (employee == null) {
            throw new ResourceNotFound("Employee not exists with email: " + login.getEmail());
        }
        else {
            System.out.println(login.getPassword());
            System.out.println(employee.getPassword());
            Boolean isPwdRight = encoder.matches(login.getPassword(),employee.getPassword());

            if(isPwdRight)
            return ResponseEntity.ok(employee);
            else
                throw new ResourceNotFound("Incorrect Credentials");
        }
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id,@RequestBody Employee employeeDetails){
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFound("Employee not exists with id :"+id));

        employee.setFirst_name(employeeDetails.getFirst_name());
        employee.setLast_name(employeeDetails.getLast_name());
        employee.setEmail(employeeDetails.getEmail());
        employee.setTitle(employeeDetails.getTitle());
        employee.setPhotograph_path(employeeDetails.getPhotograph_path());

        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFound("Employee not exists with id :"+id));
        employeeRepository.delete(employee);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
