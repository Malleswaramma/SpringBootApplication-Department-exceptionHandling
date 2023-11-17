package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Department;
import com.app.exception.DepartmentNotFoundException;
import com.app.exception.EmptyInputException;
import com.app.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepo;

	@Override
	public Department saveDepartment(Department Department) {
		
		if(Department.getDepartmentName().isEmpty() || Department.getDepartmentName().length()==0) {
			throw new EmptyInputException("fields are empty");
		}else {

		return departmentRepo.save(Department);
		}
	}

	@Override
	public List<Department> saveDepartments(List<Department> departments) {

		return departmentRepo.saveAll(departments);
	}

	@Override
	public Department getDepartmentById(Long id) {
		Optional<Department> findById = departmentRepo.findById(id);
		if (!findById.isPresent()) {
			throw new DepartmentNotFoundException("department id is +" + id + " not  found ");

		} else {
			return findById.get();
		}

	}

	@Override
	public List<Department> getAllDeparments() {

		return departmentRepo.findAll();
	}

	@Override
	public String deleteById(Long id) {
		departmentRepo.deleteById(id);

		return "deparmrnt deleted Succesfully";
	}

	@Override
	public Department updateDepartment(Department department, Long id) {

		Department department2 = departmentRepo.findById(id).get();

		department2.setDepartmentName(department.getDepartmentName());
		department2.setDepartmentAddress(department.getDepartmentAddress());
		department2.setDepartmentCode(department.getDepartmentCode());

		Department save = departmentRepo.save(department2);

		return save;
	}

	@Override
	public Department findByDepartmentName(String departmentName) {
		
		Department findByDepartmentName = departmentRepo.findByDepartmentName(departmentName);
     
		return findByDepartmentName;
		
	}

	@Override
	public Department findByDepartmentNameAndDepartmentAddress(String departmentName, String departmentAddress) {
		return departmentRepo.findByDepartmentNameAndDepartmentAddress(departmentName, departmentAddress);

	}

}
