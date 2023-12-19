package com.example.cukcukspring.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Employees")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID EmployeeId;
    private String EmployeeCode;
    private String FullName;
    private int Gender;
    private LocalDateTime DateOfBirth;
    private Long Salary;
    private String Email;
    private String PhoneNumber;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
}
