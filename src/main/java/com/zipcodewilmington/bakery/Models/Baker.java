package com.zipcodewilmington.bakery.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Baker {

    @Id
    @GeneratedValue
    @Column(name = "BAKER_ID")
    private Long id;

    @Column(name = "BAKER_NAME")
    private String name;

    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @Column(name = "SPECIALTY")
    private String specialty;

    public Baker(String name, String employeeId, String specialty) {
        this.name = name;
        this.employeeId = employeeId;
        this.specialty = specialty;
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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
