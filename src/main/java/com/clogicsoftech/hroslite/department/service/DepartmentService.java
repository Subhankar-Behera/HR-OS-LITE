package com.clogicsoftech.hroslite.department.service;

import com.clogicsoftech.hroslite.department.dto.DepartmentRequest;
import com.clogicsoftech.hroslite.department.entity.Department;
import com.clogicsoftech.hroslite.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import com.clogicsoftech.hroslite.common.exception.ResourceNotFoundException;
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

    public Department getDepartmentById(Long id) {

        return departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Department not found"));
    }
    public Department updateDepartment(
            Long id,
            DepartmentRequest request) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Department not found"));

        department.setName(request.getName());
        department.setCode(request.getCode());
        department.setDescription(request.getDescription());
        department.setStatus(request.getStatus());

        return departmentRepository.save(department);
    }
    public void deleteDepartment(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Department not found"));

        departmentRepository.delete(department);
    }
}