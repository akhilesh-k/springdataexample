package com.example.hibernateexample.service;

import com.example.hibernateexample.dto.EmployeeRequestDTO;
import com.example.hibernateexample.dto.EmployeeResponseDTO;

public interface EmployeeService {
	EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);

	EmployeeResponseDTO getEmployeeById(Long id);
	EmployeeResponseDTO updateEmployeeById(Long id,EmployeeRequestDTO employeeRequestDTO);
}
