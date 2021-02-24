package com.example.hibernateexample.repository;

import com.example.hibernateexample.entity.Department;
import com.example.hibernateexample.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	//by method name
	List<Employee> findByDepartment(Department department);

	List<Employee> findByDepartmentId(Department department);

	//by @Query annotation
	@Query("SELECT e FROM Employee e WHERE e.department.id=?1")
	//@Query("FROM Employee e WHERE e.department.id=?1")
	List<Employee> getEmployeeListByDepartmentIdParam(@Param("departmentId") Long departmentId);


	//by native query
	@Query(value = "SELECT * FROM employee e WHERE e.department_id = ?1",
			nativeQuery = true)
	List<Employee> getEmployeeListByNativeQuery(Long departmentId);

}
