package com.ebi.personhandler.dto;

import org.springframework.stereotype.Component;

@Component
public class PersonDTO {
	public String first_name;
	public String last_name;
	public int age;
	public String favourite_colour;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String firstName) {
		this.first_name = firstName;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String lastName) {
		this.last_name = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public String getFavourite_colour() {
		return favourite_colour;
	}

	public void setFavourite_colour(String favourite_colour) {
		this.favourite_colour = favourite_colour;
	}
}
