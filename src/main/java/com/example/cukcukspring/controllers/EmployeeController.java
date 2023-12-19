package com.example.cukcukspring.controllers;

import com.example.cukcukspring.models.Employee;
import com.example.cukcukspring.services.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final IEmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<?> getAllEmployees() {
        try {
            var res = employeeService.getAllEmployees();
            return ResponseEntity.ok(res);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.toString());
        }
    }
}
