package com.example.employeemanagement.dto;

import java.time.LocalDate;

public class EmployeeListView {

    private Long id;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private String departmentName;
    private LocalDate retirementDate;

    public EmployeeListView(Long id, String lastName, String firstName, LocalDate birthDate,
                            LocalDate hireDate, String departmentName, LocalDate retirementDate) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.departmentName = departmentName;
        this.retirementDate = retirementDate;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public LocalDate getRetirementDate() {
        return retirementDate;
    }
}