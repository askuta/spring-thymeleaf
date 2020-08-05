package com.epam.thymeleaf.domain;

import java.io.Serializable;

import javax.validation.constraints.Size;

@SuppressWarnings("serial")
public class Student implements Serializable {

	private Integer id;

	@Size(min = 2)
	private String name;

	private Gender gender;

	public Student() {
	}

	public Student(Integer id, String name, Gender gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}
