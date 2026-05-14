package com.clogicsoftech.hroslite.employee.dto;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeRequest {

	@NotBlank(message = "Employee code is required")
	private String employeeCode;

	@NotBlank(message = "First name is required")
	private String firstName;

	@NotBlank(message = "Last name is required")
	private String lastName;

	@Email(message = "Invalid email format")
	private String email;

	@Pattern(
		    regexp = "^[0-9]{10}$",
		    message = "Phone must be 10 digits"
		)
		private String phone;

    private LocalDate dob;

    private String gender;

    private LocalDate joiningDate;

    private String designation;

    private String employmentType;

    private String status;
}