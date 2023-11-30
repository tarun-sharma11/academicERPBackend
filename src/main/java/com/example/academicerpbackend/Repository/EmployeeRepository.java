package com.example.academicerpbackend.Repository;

import com.example.academicerpbackend.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);

    // Custom query to find employees by department name
    Employee findByEmailAndDepartment_Name(String email, String departmentName);
}
