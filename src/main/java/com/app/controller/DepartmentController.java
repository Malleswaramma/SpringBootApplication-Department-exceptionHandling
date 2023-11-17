package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Department;
import com.app.service.DepartmentService;

@RestController
@RequestMapping("/dept")

public class DepartmentController {
	@Autowired
	private DepartmentService deparmentService;
	
	private final Logger logger=LoggerFactory.getLogger(DepartmentController.class);

	/**
	 * 
	 * save department record
	 */
	@PostMapping("/saveDepartment")
	public Department saveDepartment( @RequestBody Department department) {
		logger.info("saveDepartment saved in departmentController");
		return deparmentService.saveDepartment(department);
	}

	/**
	 * 
	 * save multilple records
	 */

	@PostMapping("/saveDepartments")
	public List<Department> saveDepartments(@RequestBody List<Department> departments) {
		return deparmentService.saveDepartments(departments);
	}

	/**
	 * 
	 * fetch all records
	 */

	@GetMapping("/getDepatments")
	public List<Department> getAllDepartments() {
		
		logger.info(" inside  getAllDepartments of departmentController ");
		return deparmentService.getAllDeparments();
	}

	@GetMapping("/getDepartmentById/{id}")
	public Department getdepartmentById(@PathVariable("id") Long id) {
		logger.info(" inside  getdepartmentById of departmentController ");
		return deparmentService.getDepartmentById(id);
	}

	@PutMapping("/updateDepartment/{id}")
	public Department getdepartmentById(@RequestBody Department department, @PathVariable("id") Long id) {
		return deparmentService.updateDepartment(department, id);
	}

	@DeleteMapping("deleteDept/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long id) {
		deparmentService.deleteById(id);

		return "deleted successfully";

	}

	@GetMapping("/findBy/{departmentName}")
	public Department findByDepartmentName(@PathVariable("departmentName") String departmentName) {
		return deparmentService.findByDepartmentName(departmentName);

	}

	@GetMapping("/findBy/{departmentName}/{departmentAddress}")
	public Department findByDepartmentNameAndDepartmentAddress(@PathVariable("departmentName") String departmentName,
			@PathVariable("departmentAddress") String departmentAddress) {
		return deparmentService.findByDepartmentNameAndDepartmentAddress(departmentName, departmentAddress);

	}

}
