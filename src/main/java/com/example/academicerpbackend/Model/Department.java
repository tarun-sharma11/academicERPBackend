package com.example.academicerpbackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "DEPARTMENTS")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long department_id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CAPACITY")
    private long capacity;

    @OneToMany(mappedBy = "department")
    @JsonIgnoreProperties("department")
    private Set<Employee> employees;

    public long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(long department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public Department() {
    }

    public Department(String name, long capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}
