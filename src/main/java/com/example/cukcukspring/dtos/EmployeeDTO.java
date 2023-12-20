package com.example.cukcukspring.dtos;

import com.example.cukcukspring.models.Department;
import com.example.cukcukspring.models.Position;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @NotBlank(message = "Code is required")
    private String EmployeeCode;
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 200, message = "Name must be between 3 and 200 characters")
    private String FullName;
    private int Gender;
    private LocalDateTime DateOfBirth;
    private Long Salary;
    private String Email;
    private String PhoneNumber;
    @JsonProperty("department_id")
    private UUID departmentId;
    @JsonProperty("position_id")
    private UUID positionId;
}
