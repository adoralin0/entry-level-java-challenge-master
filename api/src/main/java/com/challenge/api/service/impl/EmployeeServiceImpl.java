package com.challenge.api.service.impl;

import com.challenge.api.model.CreateEmployeeRequest;
import com.challenge.api.model.Employee;
import com.challenge.api.service.EmployeeService;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<UUID, Employee> employeeStore = new ConcurrentHashMap<>();

    public EmployeeServiceImpl() {
        UUID initialId = UUID.randomUUID();
        employeeStore.put(
                initialId,
                new Employee(
                        initialId,
                        "Alex",
                        "Morgan",
                        "alex.morgan@company.com",
                        "Security Analyst",
                        "SecOps",
                        Instant.now()));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeStore.values());
    }

    @Override
    public Optional<Employee> getEmployeeByUuid(UUID uuid) {
        return Optional.ofNullable(employeeStore.get(uuid));
    }

    @Override
    public Employee createEmployee(CreateEmployeeRequest request) {
        UUID newId = UUID.randomUUID();
        Employee newEmployee =
                new Employee(
                        newId,
                        request.firstName(),
                        request.lastName(),
                        request.email(),
                        request.title(),
                        request.department(),
                        Instant.now());
        employeeStore.put(newId, newEmployee);
        return newEmployee;
    }
}