package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeListView;
import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.entity.EmployeeDepartmentHistory;
import com.example.employeemanagement.repository.DepartmentRepository;
import com.example.employeemanagement.repository.EmployeeDepartmentHistoryRepository;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeDepartmentHistoryRepository employeeDepartmentHistoryRepository;

    public EmployeeController(EmployeeRepository employeeRepository,
                              DepartmentRepository departmentRepository,
                              EmployeeDepartmentHistoryRepository employeeDepartmentHistoryRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.employeeDepartmentHistoryRepository = employeeDepartmentHistoryRepository;
    }

    @GetMapping
    public String showList(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeListView> employeeList = new ArrayList<>();

        for (Employee employee : employees) {
            String departmentName = "未設定";

            Optional<EmployeeDepartmentHistory> historyOpt =
                    employeeDepartmentHistoryRepository.findTopByEmployeeIdOrderByStartDateDescUpdatedAtDesc(employee.getId());

            if (historyOpt.isPresent()) {
                Long departmentId = historyOpt.get().getDepartmentId();
                Optional<Department> departmentOpt = departmentRepository.findById(departmentId);
                if (departmentOpt.isPresent()) {
                    departmentName = departmentOpt.get().getDepartmentName();
                }
            }

            employeeList.add(new EmployeeListView(
                    employee.getId(),
                    employee.getLastName(),
                    employee.getFirstName(),
                    employee.getBirthDate(),
                    employee.getHireDate(),
                    departmentName,
                    employee.getRetirementDate()
            ));
        }

        model.addAttribute("employees", employeeList);
        return "employee/list";
    }
}