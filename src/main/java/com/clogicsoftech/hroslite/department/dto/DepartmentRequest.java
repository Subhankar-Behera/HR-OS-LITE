package com.clogicsoftech.hroslite.department.dto;

import jakarta.validation.constraints.NotBlank;

public class DepartmentRequest {

	@NotBlank(message = "Department name is required")
	private String name;

	@NotBlank(message = "Department code is required")
	private String code;

    private String description;

    private String status;

    public DepartmentRequest() {
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