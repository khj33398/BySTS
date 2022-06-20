package com.metanet.empj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metanet.empj.service.JpaService;

@Controller
public class EmployeeController {
	@Autowired
	JpaService jpaService;

	@ResponseBody
	@GetMapping("/emp/{id}")
	public String getEmp(@PathVariable Integer id) {
		return jpaService.findEmployee(id).toString();
	}

	@ResponseBody
	@GetMapping("/dept/{id}")
	public String getDept(@PathVariable Integer id) {
		return jpaService.findDepartment(id).toString();
	}

	@ResponseBody
	@GetMapping("/emps/{name}")
	public String getEmpList(@PathVariable String name) {
		return jpaService.findEmpListByName(name).toString();
	}
}
