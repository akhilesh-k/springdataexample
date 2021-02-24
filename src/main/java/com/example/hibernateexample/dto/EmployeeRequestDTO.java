package com.example.hibernateexample.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDTO {

	private long id;
	private String name;
	private String code;
	private DepartmentRequestDTO department;
}
