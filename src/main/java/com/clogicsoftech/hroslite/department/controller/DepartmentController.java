package com.clogicsoftech.hroslite.department.controller;

import com.clogicsoftech.hroslite.department.dto.DepartmentRequest;
import com.clogicsoftech.hroslite.department.entity.Department;
import com.clogicsoftech.hroslite.department.service.DepartmentService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(
            DepartmentService departmentService) {

        this.departmentService = departmentService;
    }

    @PostMapping
    public Department createDepartment(
    		@Valid @RequestBody DepartmentRequest request) {

        return departmentService.createDepartment(request);
    }

    @GetMapping
    public List<Department> getAllDepartments() {

        return departmentService.getAllDepartments();
    }
    @GetMapping("/{id}")
    public Department getDepartmentById(
            @PathVariable Long id) {

        return departmentService.getDepartmentById(id);
    }
    @PutMapping("/{id}")
    public Department updateDepartment(
            @PathVariable Long id,
            @RequestBody DepartmentRequest request) {

        return departmentService.updateDepartment(id, request);
    }
    @DeleteMapping("/{id}")
    public String deleteDepartment(
            @PathVariable Long id) {

        departmentService.deleteDepartment(id);

        return "Department deleted successfully";
    }
}