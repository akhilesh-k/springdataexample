package com.example.hibernateexample.service;

import com.example.hibernateexample.dto.EmployeeRequestDTO;
import com.example.hibernateexample.dto.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
	EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);

	EmployeeResponseDTO getEmployeeById(Long id);
	EmployeeResponseDTO updateEmployeeById(Long id,EmployeeRequestDTO employeeRequestDTO);
	EmployeeResponseDTO deleteEmployeeById(Long id);
	List<EmployeeResponseDTO>getEmployeeListByDepartment(Long departmentId);
}
