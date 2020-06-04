package com.EmployeeManagement.Employee.Entity;

import javax.persistence.*;

@Entity
public class Employee {
    @Id //specifies the primary key of the entity
    @GeneratedValue //provides specification of generation strategies of primary key
    private Long id;
    private String name;
    private String dob;
    private String address;
    private String department;

    public Employee() {
    }

    public Employee(Long id, String name, String dob, String address, String department) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
