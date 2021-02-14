package com.ebi.personhandler.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Person implements Serializable{
	
	private static final long serialVersionUID = 123173L;

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
	@SequenceGenerator(name = "id_sequence", sequenceName = "id_sequence", allocationSize = 100)
	@Column(name = "id")
	@Id
	public int id;	

	@Column(name="first_name")
	private String first_name;


	@Column(name="last_name")
	private String last_name;
	
	@Column
	private int age;
	
	@Column
	private String favourite_colour;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
}
