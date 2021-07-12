package com.example.demo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;






@Entity
public class Student {
	@Id
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private BigDecimal greade;
	
	public Student() {
		super();
	}
	public Student(Long id, String name, BigDecimal greade) {
		super();
		this.id = id;
		this.name = name;
		this.greade = greade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getGreade() {
		return greade;
	}
	public void setGreade(BigDecimal greade) {
		this.greade = greade;
	}




}
