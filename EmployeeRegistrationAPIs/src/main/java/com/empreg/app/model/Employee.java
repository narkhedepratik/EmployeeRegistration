package com.empreg.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
	   @Id
	private Integer employeeId;
	private String employeeName;
	private String dateOfJoing;
	@OneToOne(cascade = CascadeType.ALL)
	private Department department;


}
