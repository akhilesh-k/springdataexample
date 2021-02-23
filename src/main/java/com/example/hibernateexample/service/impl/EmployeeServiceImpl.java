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

import java.security.PublicKey;
import java.util.Optional;

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
	@Override
	public EmployeeResponseDTO getEmployeeById(Long id){
		Optional<Employee>employeeOptional=employeeRepository.findById(id);
		if(employeeOptional.isPresent()){
			//copy from employee to response dto
			EmployeeResponseDTO responseDTO=new EmployeeResponseDTO();
			BeanUtils.copyProperties(employeeOptional.get(),responseDTO);
			return responseDTO;
		}
		return null;
	}
	@Override
	public EmployeeResponseDTO updateEmployeeById(Long id, EmployeeRequestDTO employeeRequestDTO){
		Optional<Employee>employeeOptional=employeeRepository.findById(id);
		if(employeeOptional.isPresent()){
			//copy from employee
			Employee employeeFromDb=employeeOptional.get();
			employeeFromDb.setName(employeeRequestDTO.getName());
			employeeFromDb.setDepartmentName(employeeRequestDTO.getDepartmentName());

			//save to db
			Employee savedEmployee=employeeRepository.save(employeeFromDb);

			//copy from employee to responseDTO
			EmployeeResponseDTO responseDTO=new EmployeeResponseDTO();
			BeanUtils.copyProperties(savedEmployee,responseDTO);

			return responseDTO;
		}
		return null;
	}
}
