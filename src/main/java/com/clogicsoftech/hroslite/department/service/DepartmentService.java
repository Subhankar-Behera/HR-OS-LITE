package com.clogicsoftech.hroslite.department.service;

import com.clogicsoftech.hroslite.department.dto.DepartmentRequest;
import com.clogicsoftech.hroslite.department.entity.Department;
import com.clogicsoftech.hroslite.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(
            DepartmentRepository departmentRepository) {

        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(
            DepartmentRequest request) {

        Department department = new Department();

        department.setName(request.getName());
        department.setCode(request.getCode());
        department.setDescription(request.getDescription());
        department.setStatus(request.getStatus());

        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {

        return departmentRepository.findAll();
    }
}