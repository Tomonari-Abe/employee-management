package com.example.employeemanagement.repository;

import com.example.employeemanagement.entity.EmployeeDepartmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeDepartmentHistoryRepository extends JpaRepository<EmployeeDepartmentHistory, Long> {

    Optional<EmployeeDepartmentHistory> findTopByEmployeeIdOrderByStartDateDescUpdatedAtDesc(Long employeeId);
}