package com.epam.thymeleaf.domain;

public enum Gender {

	FEMALE("Female gender"),
	MALE("Male gender");

	private String description;

	private Gender(final String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
}
