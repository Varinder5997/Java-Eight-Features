package com.mindtree.javaeightnewfeature.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private long id;
	@Column(name = "username",nullable = false)
	private String name;
	@Column(name = "userAge",nullable = false)
	private UserAge userAge;
	@Column(name = "isInfant")
	private boolean isInfant;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isInfant() {
		return isInfant;
	}
	public void setInfant(boolean isInfant) {
		this.isInfant = isInfant;
	}
	public UserAge getUserAge() {
		return userAge;
	}
	public void setUserAge(UserAge userAge) {
		this.userAge = userAge;
	}
	
	
}
