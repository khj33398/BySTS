package com.metanet.empj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metanet.empj.model.EmployeeJ;

public interface EmployeeRepository extends JpaRepository<EmployeeJ, Integer>{
	List<EmployeeJ> findByName(String name);
}
