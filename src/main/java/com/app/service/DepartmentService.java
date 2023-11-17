package com.app.service;

import java.util.List;

import com.app.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department Department);

	public List<Department> saveDepartments(List<Department> departments);

	public Department getDepartmentById(Long id);

	public List<Department> getAllDeparments();

	public String deleteById(Long id);

	public Department updateDepartment(Department department, Long id);
	
	public Department findByDepartmentName(String departmentName);

	public Department findByDepartmentNameAndDepartmentAddress(String departmentName, String departmentAddress);


}
