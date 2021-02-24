package com.example.hibernateexample.service;

import com.example.hibernateexample.dto.DepartmentRequestDTO;
import com.example.hibernateexample.dto.DepartmentResponseDTO;

public interface DepartmentService {
	DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequestDTO);
}
