package com.example.cukcukspring.services;

import com.example.cukcukspring.exceptions.DataNotFoundException;
import com.example.cukcukspring.models.Employee;
import com.example.cukcukspring.dtos.EmployeeDTO;

import java.util.List;
import java.util.UUID;

public interface IEmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(UUID employeeId) throws DataNotFoundException;

    Employee createEmployee(Employee employee) throws DataNotFoundException;

    Employee updateEmployee(UUID employeeId, Employee employee) throws DataNotFoundException;

    void deleteEmployee(UUID employeeId) throws DataNotFoundException;
}
