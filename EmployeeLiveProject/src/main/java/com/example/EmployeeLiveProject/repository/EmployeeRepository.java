package com.example.EmployeeLiveProject.repository;


import com.example.EmployeeLiveProject.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}

