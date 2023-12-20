package com.example.cukcukspring.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("EmployeeId")
    private UUID EmployeeId;
    @JsonProperty("EmployeeCode")
    private String EmployeeCode;
    @JsonProperty("FullName")
    private String FullName;
    @JsonProperty("Gender")
    private int Gender;
    @JsonProperty("DateOfBirth")
    private LocalDate DateOfBirth;
    @JsonProperty("Salary")
    private Long Salary;
    @JsonProperty("Email")
    private String Email;
    @JsonProperty("PhoneNumber")
    private String PhoneNumber;
    @JsonProperty("Address")
    private String Address;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
}
