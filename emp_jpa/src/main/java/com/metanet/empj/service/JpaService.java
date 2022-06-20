package com.metanet.empj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.empj.model.DepartmentJ;
import com.metanet.empj.model.EmployeeJ;
import com.metanet.empj.repository.DepartmentRepository;
import com.metanet.empj.repository.EmployeeRepository;

@Service
public class JpaService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public EmployeeJ findEmployee(Integer id) {
		EmployeeJ employeeJ = employeeRepository.findById(id).get();		
		return employeeJ;
	}
	
	public DepartmentJ findDepartment(Integer id) {
		return departmentRepository.findById(id).get();
	}
	
	public List<EmployeeJ> findEmpListByName(String name){
		return  employeeRepository.findByName(name);
	}
	
	
}
