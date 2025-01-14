package com.example.cukcukspring.repositories;

import com.example.cukcukspring.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
