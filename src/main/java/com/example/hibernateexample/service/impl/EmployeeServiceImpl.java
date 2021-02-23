package com.example.hibernateexample.service.impl;

import com.example.hibernateexample.dto.EmployeeRequestDTO;
import com.example.hibernateexample.dto.EmployeeResponseDTO;
import com.example.hibernateexample.entity.Employee;
import com.example.hibernateexample.repository.EmployeeRepository;
import com.example.hibernateexample.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO){
		Employee employee=new Employee();
		//copy fields from DTO to employee
		BeanUtils.copyProperties(employeeRequestDTO,employee);

		//save employee to DB
		Employee savedEmployee=employeeRepository.save(employee);

		//copy from employee to responseDTO
		EmployeeResponseDTO responseDTO=new EmployeeResponseDTO();
		BeanUtils.copyProperties(savedEmployee,responseDTO);

		return responseDTO;
	}
}
