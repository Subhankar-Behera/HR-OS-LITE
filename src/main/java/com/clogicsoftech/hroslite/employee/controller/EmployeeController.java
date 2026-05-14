package com.clogicsoftech.hroslite.employee.controller;
import com.clogicsoftech.hroslite.common.api.ApiResponse;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.clogicsoftech.hroslite.employee.dto.EmployeeRequest;
import com.clogicsoftech.hroslite.employee.entity.Employee;
import com.clogicsoftech.hroslite.employee.service.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/employee")

@RequiredArgsConstructor

public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/profile")
    public String employeeProfile() {

        return "Protected Employee Profile";
    }

    
    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> createEmployee(
            @Valid @RequestBody EmployeeRequest request) {

        Employee employee =
                employeeService.createEmployee(request);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Employee created successfully",
                        employee
                )
        );
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(
            @PathVariable Long id) {

        return employeeService.getEmployeeById(id);
    }
    
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {

        return ResponseEntity.ok(
                employeeService.getAllEmployees()
        );
    }
    @PutMapping("/{id}")

    public Employee updateEmployee(

            @PathVariable Long id,

            @Valid @RequestBody EmployeeRequest request) {

        return employeeService.updateEmployee(id, request);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.ok(
                "Employee deleted successfully"
        );
    }
}