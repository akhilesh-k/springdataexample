package com.example.hibernateexample.controller;

import com.example.hibernateexample.dto.DepartmentRequestDTO;
import com.example.hibernateexample.dto.DepartmentResponseDTO;
import com.example.hibernateexample.entity.Department;
import com.example.hibernateexample.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@PostMapping
	public DepartmentResponseDTO createDepartment(@RequestBody DepartmentRequestDTO departmentRequestDTO){
		return departmentService.createDepartment(departmentRequestDTO);
	}
	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable("id") Long id){
		return departmentService.getDepartmentById(id);
	}
	@PutMapping("/{id}")
	public DepartmentResponseDTO updateDepartment
			(@PathVariable("id") Long departmentId,
			 @RequestBody DepartmentRequestDTO departmentRequestDto){
		return departmentService.updateDepartment(departmentId,departmentRequestDto);
	}
}
