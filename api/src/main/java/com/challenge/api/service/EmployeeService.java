package com.challenge.api.service;

import com.challenge.api.model.CreateEmployeeRequest;
import com.challenge.api.model.Employee;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeByUuid(UUID uuid);

    Employee createEmployee(CreateEmployeeRequest request);
}