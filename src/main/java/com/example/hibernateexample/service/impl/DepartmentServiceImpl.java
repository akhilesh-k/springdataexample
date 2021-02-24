package com.example.hibernateexample.service.impl;

import com.example.hibernateexample.dto.DepartmentRequestDTO;
import com.example.hibernateexample.dto.DepartmentResponseDTO;
import com.example.hibernateexample.entity.Department;
import com.example.hibernateexample.entity.Employee;
import com.example.hibernateexample.repository.DepartmentRepository;
import com.example.hibernateexample.repository.EmployeeRepository;
import com.example.hibernateexample.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequestDTO){
		Department department=new Department();
		BeanUtils.copyProperties(departmentRequestDTO,department);

		Department savedDepartment=departmentRepository.save(department);

		DepartmentResponseDTO responseDTO=new DepartmentResponseDTO();
		BeanUtils.copyProperties(savedDepartment,responseDTO);

		return responseDTO;
	}
	@Override
	public Department getDepartmentById(Long id) {
		return departmentRepository.findById(id).get();
	}
	@Override
	public DepartmentResponseDTO updateDepartment(Long departmentId, DepartmentRequestDTO departmentRequestDTO){
		Department department=departmentRepository.findById(departmentId).get();
		List<Employee> employeeList=employeeRepository.findByDepartment_Id(departmentId);

		//update department
		department.setName(departmentRequestDTO.getName());
		Department savedDepartment=departmentRepository.save(department);

		//append departmentcode to employee code

		DepartmentResponseDTO responseDTO=new DepartmentResponseDTO();
		BeanUtils.copyProperties(savedDepartment,responseDTO);
		return responseDTO;
	}
}
