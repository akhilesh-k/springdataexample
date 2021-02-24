package com.example.hibernateexample.service;

import com.example.hibernateexample.dto.DepartmentRequestDTO;
import com.example.hibernateexample.dto.DepartmentResponseDTO;
import com.example.hibernateexample.entity.Department;

public interface DepartmentService {
	DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequestDTO);
	Department getDepartmentById(Long Id);
}
