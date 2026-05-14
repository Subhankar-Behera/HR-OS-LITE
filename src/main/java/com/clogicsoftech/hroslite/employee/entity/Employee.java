package com.clogicsoftech.hroslite.employee.entity;

import java.time.LocalDate;

import com.clogicsoftech.hroslite.auth.entity.User;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String employeeCode;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private LocalDate dob;

    private String gender;

    private LocalDate joiningDate;

    private String designation;

    private String employmentType;

    private String status;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}