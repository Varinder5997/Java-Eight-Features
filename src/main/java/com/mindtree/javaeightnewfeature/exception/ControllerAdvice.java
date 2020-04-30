package com.mindtree.javaeightnewfeature.exception;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.javaeightnewfeature.dto.ErrorResponse;
import com.mindtree.javaeightnewfeature.dto.ResponseBody;
import com.mindtree.javaeightnewfeature.exception.service.ServiceException;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<?> gernalException(ApplicationExceptionn e) {
		return new ResponseEntity<ResponseBody<Void>>(
				new ResponseBody<Void>(null,new ErrorResponse(e.getMessage()),e.getMessage(),false),
				HttpStatus.OK);
		//return new ErrorResponse(HttpStatus.BAD_REQUEST,e.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
		String errorMessaage="";
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			errorMessaage +=error.getDefaultMessage() +" , ";
		}
		return new ResponseEntity<ResponseBody<Void>>(
				new ResponseBody<Void>(null,new ErrorResponse(errorMessaage),ex.getMessage(),false),
				HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<?> sqlExceptionHandles(MethodArgumentNotValidException ex){
		String errorMessaage="";
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			errorMessaage +=error.getDefaultMessage() +" , ";
		}
		return new ResponseEntity<ResponseBody<Void>>(
				new ResponseBody<Void>(null,new ErrorResponse(errorMessaage),ex.getMessage(),false),
				HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
}
