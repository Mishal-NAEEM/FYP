package com.fypproject.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="patient")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false,unique=true)
	private String email;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String city;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="patients")
	private List<DOP> physioterapists;
	
	//Constructors
	public Patient(String name, String email, String address, String city) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.city = city;
	}

	public Patient() {
		super();
	}
	//Getter and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<DOP> getPhysioterapists() {
		return physioterapists;
	}

	public void setPhysioterapists(List<DOP> physioterapists) {
		this.physioterapists = physioterapists;
	}
	
	
}
