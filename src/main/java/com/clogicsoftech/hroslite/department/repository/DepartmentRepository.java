package com.clogicsoftech.hroslite.department.repository;

import com.clogicsoftech.hroslite.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository
        extends JpaRepository<Department, Long> {

}