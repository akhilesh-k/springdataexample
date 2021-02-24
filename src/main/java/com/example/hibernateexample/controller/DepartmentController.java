package com.example.hibernateexample.controller;

import com.example.hibernateexample.dto.DepartmentRequestDTO;
import com.example.hibernateexample.dto.DepartmentResponseDTO;
import com.example.hibernateexample.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@PostMapping
	public DepartmentResponseDTO createDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO){
		return departmentService.createDepartment(departmentRequestDTO);
	}
}
