package com.example.hibernateexample.dto;

import com.example.hibernateexample.entity.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDTO {

	private long id;
	private String name;
	private DepartmentResponseDTO department;
	public void setDepartmentFromEntity(Department departmentEntity){
		DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
		departmentResponseDTO.setId(departmentEntity.getId());
		departmentResponseDTO.setName(departmentEntity.getName());
		this.department=departmentResponseDTO;
	}
}
