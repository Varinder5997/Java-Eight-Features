package com.mindtree.javaeightnewfeature.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

public class UserDto {
	@NonNull
	@Length(min = 4,max = 10)
	private String userName;
	@Min(1)
	@Max(10)
	private int userAge;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}


	
}
