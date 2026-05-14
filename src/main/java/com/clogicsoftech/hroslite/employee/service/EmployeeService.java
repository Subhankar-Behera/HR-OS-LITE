package com.clogicsoftech.hroslite.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clogicsoftech.hroslite.auth.entity.User;
import com.clogicsoftech.hroslite.auth.repository.UserRepository;
import com.clogicsoftech.hroslite.common.exception.ResourceNotFoundException;
import com.clogicsoftech.hroslite.employee.dto.EmployeeRequest;
import com.clogicsoftech.hroslite.employee.entity.Employee;
import com.clogicsoftech.hroslite.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final UserRepository userRepository;

    public Employee createEmployee(EmployeeRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"
                        ));

        Employee employee = Employee.builder()
                .employeeCode(request.getEmployeeCode())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .dob(request.getDob())
                .gender(request.getGender())
                .joiningDate(request.getJoiningDate())
                .designation(request.getDesignation())
                .employmentType(request.getEmploymentType())
                .status(request.getStatus())
                .user(user)
                .build();

        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found"
                        ));
    }

    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    public Employee updateEmployee(
            Long id,
            EmployeeRequest request) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found"
                        ));

        employee.setEmployeeCode(request.getEmployeeCode());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setDob(request.getDob());
        employee.setGender(request.getGender());
        employee.setJoiningDate(request.getJoiningDate());
        employee.setDesignation(request.getDesignation());
        employee.setEmploymentType(request.getEmploymentType());
        employee.setStatus(request.getStatus());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found"
                        ));

        employeeRepository.delete(employee);
    }
}