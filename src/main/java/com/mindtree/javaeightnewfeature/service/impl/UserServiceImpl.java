package com.mindtree.javaeightnewfeature.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.javaeightnewfeature.dto.UserDto;
import com.mindtree.javaeightnewfeature.entity.User;
import com.mindtree.javaeightnewfeature.entity.UserAge;
import com.mindtree.javaeightnewfeature.exception.service.NoanyUserEnter;
import com.mindtree.javaeightnewfeature.exception.service.NoanyUserPresent;
import com.mindtree.javaeightnewfeature.exception.service.ServiceException;
import com.mindtree.javaeightnewfeature.repository.Userrepo;
import com.mindtree.javaeightnewfeature.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	Userrepo userRepo;

	@Override
	public List<User> adduser(List<UserDto> allUsers) throws ServiceException {
		allUsers.stream().findAny().orElseThrow(()->new NoanyUserEnter("Pleace Enter atleast one user"));
		List<User>users=allUsers.stream().map(userdto->convertToUser(userdto)).collect(Collectors.toList());
		
		return users.stream().map(user->this.userRepo.save(user)).collect(Collectors.toList());
	}
	
	
	private User convertToUser(UserDto userDto) {
		User user=new User();
		user.setName(userDto.getUserName());
		user.setUserAge(convertingOfAge(userDto.getUserAge()));
		user.setInfant(checkInfant(userDto.getUserAge()));
		return user;
	}
	
	private boolean checkInfant(int age) {
		if(age<2) {
			return true;
		}
		else {
		return false;
		}
		
	}
	
	private UserAge convertingOfAge(int age) {
		switch (age) {
		case 1:
			return UserAge.One;
		case 2:
			return UserAge.Two;
		case 3:
			return UserAge.Three;
		case 4:
			return UserAge.Four;
		case 5:
			return UserAge.Five;
		case 6:
			return UserAge.Six;
		case 7:
			return UserAge.Seven;
		case 8:
			return UserAge.Eight;
		case 9:
			return UserAge.Nine;
		case 10:
			return UserAge.Ten;

		default:
			return UserAge.Ten;
		}
	}
	
	private int convertstringtoInteger(UserAge userage) {
		switch (userage) {
		case One:
			return 1;
		case Two:
			return 2;
		case Three:
			return 3;
		case Four:
			return 4;
		case Five:
			return 5;
		case Six:
			return 6;
		case Seven:
			return 7;
		case Eight:
			return 8;
		case Nine:
			return 9;
		case Ten:
			return 10;

		default:
			return 10;
		}
	}
	
	private UserDto convertToDto(User user) {
		UserDto userDto=new UserDto();
		userDto.setUserAge(convertstringtoInteger(user.getUserAge()));
		return userDto;
	}


	@Override
	public long sumOfAge() throws ServiceException {
		List<User>allUsers=this.userRepo.findAll();
		List<UserDto>users=allUsers.stream().map(userDto->convertToDto(userDto)).filter(x->x.getUserAge()>6).collect(Collectors.toList());
		List<UserDto>user=users.stream().filter(x->x.getUserAge()>6).collect(Collectors.toList());
		user.stream().findAny().orElseThrow(()->new NoanyUserPresent("No any user whose age greater then six"));
		List<Integer>age=user.stream().map(x->x.getUserAge()).collect(Collectors.toList());

		long totalage=age.stream().reduce((int) 0, (a,b) -> a + b );
		return totalage;
	}

}
