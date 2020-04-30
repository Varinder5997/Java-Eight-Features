package com.mindtree.javaeightnewfeature.controller;

import java.util.List;

import javax.persistence.GeneratedValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.javaeightnewfeature.dto.ResponseBody;
import com.mindtree.javaeightnewfeature.dto.UserDto;
import com.mindtree.javaeightnewfeature.entity.User;
import com.mindtree.javaeightnewfeature.exception.ApplicationExceptionn;
import com.mindtree.javaeightnewfeature.exception.service.ServiceException;
import com.mindtree.javaeightnewfeature.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
		
	@PostMapping("/adduser")
	public ResponseEntity<?> addUser(@RequestBody List<UserDto> allUsers) throws ApplicationExceptionn{
		List<User> c=this.userService.adduser(allUsers);
		return new ResponseEntity<ResponseBody<List<User>>>(new ResponseBody<List<User>>(c,null,"All User of facility",true),
				HttpStatus.OK);
		
		
	}
	
	@GetMapping("/getage")
	public ResponseEntity<?> sumOfAge() throws ApplicationExceptionn {
		Long c= this.userService.sumOfAge();
		return new ResponseEntity<ResponseBody<Long>>(new ResponseBody<Long>(c,null,"Sum of Age of User",true),
				HttpStatus.OK);
	}
}
