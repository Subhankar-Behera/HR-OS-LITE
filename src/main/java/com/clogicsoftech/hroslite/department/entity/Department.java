package com.clogicsoftech.hroslite.department.entity;

import jakarta.persistence.*;
import java.util.List;
import com.clogicsoftech.hroslite.employee.entity.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Employee> employees;
    
    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String code;

    private String description;

    private String status;

    public Department() {
    }

    public Department(Long id, String name, String code,
                      String description, String status) {

        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}