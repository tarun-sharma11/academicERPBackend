package com.example.academicerpbackend.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employee_id;

    public Employee() {
    }

    public Employee(String first_name, String last_name, String email, String title, String photograph_path, Department department) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.title = title;
        this.photograph_path = photograph_path;
        this.department = department;
    }

    @Column(name = "FIRST_NAME")
    private String first_name;
    @Column(name = "LAST_NAME")
    private String last_name;

    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "PHOTOGRAPH_PATH")
    private String photograph_path;

    @ManyToOne(targetEntity = Department.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "DEPARTMENT_ID",referencedColumnName = "department_id", nullable = false)
    private Department department;

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotograph_path() {
        return photograph_path;
    }

    public void setPhotograph_path(String photograph_path) {
        this.photograph_path = photograph_path;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
