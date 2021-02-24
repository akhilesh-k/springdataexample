package com.example.hibernateexample.service.impl;

import com.example.hibernateexample.dto.DepartmentRequestDTO;
import com.example.hibernateexample.dto.DepartmentResponseDTO;
import com.example.hibernateexample.entity.Department;
import com.example.hibernateexample.repository.DepartmentRepository;
import com.example.hibernateexample.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
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
}
