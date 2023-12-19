package com.example.cukcukspring.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "Departments")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID DepartmentId;
    @Column(nullable = false)
    private String DepartmentCode;
    @Column(nullable = false)
    private String DepartmentName;
    private String Description;
}
