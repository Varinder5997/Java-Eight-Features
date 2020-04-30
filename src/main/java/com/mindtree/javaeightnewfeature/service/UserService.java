package com.mindtree.javaeightnewfeature.service;

import java.util.List;

import com.mindtree.javaeightnewfeature.dto.UserDto;
import com.mindtree.javaeightnewfeature.entity.User;
import com.mindtree.javaeightnewfeature.exception.service.ServiceException;

public interface UserService {
	
	public List<User> adduser(List<UserDto> allUsers) throws ServiceException;
	
	public long sumOfAge() throws ServiceException;

}
