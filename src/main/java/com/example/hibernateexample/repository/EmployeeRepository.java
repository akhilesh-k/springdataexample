package com.example.hibernateexample.repository;

import com.example.hibernateexample.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {}
