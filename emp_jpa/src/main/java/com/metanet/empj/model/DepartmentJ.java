package com.metanet.empj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentJ {
	@Id
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//	@JoinColumn(name="DEPARTMENT_ID")
//	@JsonManagedReference
//	private List<EmployeeJ> empList = new ArrayList<EmployeeJ>();

	
}
