package com.example.hibernateexample.controller;

import com.example.hibernateexample.dto.EmployeeRequestDTO;
import com.example.hibernateexample.dto.EmployeeResponseDTO;
import com.example.hibernateexample.entity.Employee;
import com.example.hibernateexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	//POST 		/employee
	@PostMapping
	public EmployeeResponseDTO createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
		return employeeService.createEmployee(employeeRequestDTO);
	}
	//GET 		/employee/{id}
	@GetMapping
	public EmployeeResponseDTO getEmployeeById(@PathVariable("id")Long id){
		return employeeService.getEmployeeById(id);
	}
	//PUT 		/employee/{id}
	//DELETE 	/employee{id}
}
