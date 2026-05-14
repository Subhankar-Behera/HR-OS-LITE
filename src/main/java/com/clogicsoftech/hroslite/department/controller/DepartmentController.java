package com.clogicsoftech.hroslite.department.controller;

import com.clogicsoftech.hroslite.department.dto.DepartmentRequest;
import com.clogicsoftech.hroslite.department.entity.Department;
import com.clogicsoftech.hroslite.department.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

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
            @RequestBody DepartmentRequest request) {

        return departmentService.createDepartment(request);
    }

    @GetMapping
    public List<Department> getAllDepartments() {

        return departmentService.getAllDepartments();
    }
}