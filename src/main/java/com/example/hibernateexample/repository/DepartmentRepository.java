package com.example.hibernateexample.repository;

import com.example.hibernateexample.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department,Long>{}
