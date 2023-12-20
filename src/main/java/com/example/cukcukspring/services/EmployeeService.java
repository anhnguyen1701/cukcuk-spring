package com.example.cukcukspring.services;

import com.example.cukcukspring.exceptions.DataNotFoundException;
import com.example.cukcukspring.models.Employee;
import com.example.cukcukspring.repositories.DepartmentRepository;
import com.example.cukcukspring.repositories.EmployeeRepository;
import com.example.cukcukspring.repositories.PositionRepository;
import com.example.cukcukspring.dtos.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(UUID employeeId) throws DataNotFoundException {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new DataNotFoundException("Employee not found"));
    }

    @Override
    public Employee createEmployee(Employee employee) throws DataNotFoundException {
        if (employee.getPosition() != null) {
            positionRepository.findById(employee.getPosition().getPositionId())
                    .orElseThrow(() ->
                            new DataNotFoundException(
                                    "Cannot find Position with id: " + employee.getPosition().getPositionId()));
        }
        if (employee.getDepartment() != null) {
            departmentRepository.findById(employee.getDepartment().getDepartmentId())
                    .orElseThrow(() ->
                            new DataNotFoundException(
                                    "Cannot find Department with id: " + employee.getDepartment().getDepartmentId()));
        }

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(UUID employeeId, Employee employee) throws DataNotFoundException {
        Employee existEmployee = getEmployeeById(employeeId);
        if (employee.getPosition() != null) {
            var position = positionRepository.findById(employee.getPosition().getPositionId())
                    .orElseThrow(() ->
                            new DataNotFoundException(
                                    "Cannot find Position with id: " + employee.getPosition().getPositionId()));
            existEmployee.setPosition(position);
        }
        if (employee.getDepartment() != null) {
            var department = departmentRepository.findById(employee.getDepartment().getDepartmentId())
                    .orElseThrow(() ->
                            new DataNotFoundException(
                                    "Cannot find Department with id: " + employee.getDepartment().getDepartmentId()));
            existEmployee.setDepartment(department);
        }
        existEmployee.setEmail(employee.getEmail());
        existEmployee.setSalary(employee.getSalary());
        existEmployee.setPhoneNumber(employee.getPhoneNumber());
        existEmployee.setGender(employee.getGender());
        existEmployee.setFullName(employee.getFullName());
        existEmployee.setDateOfBirth(employee.getDateOfBirth());
        return employeeRepository.save(existEmployee);
    }

    @Override
    public void deleteEmployee(UUID employeeId) throws DataNotFoundException {
        Employee existEmployee = getEmployeeById(employeeId);
        employeeRepository.deleteById(employeeId);
    }
}
