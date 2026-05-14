package com.clogicsoftech.hroslite.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clogicsoftech.hroslite.employee.entity.Employee;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

}