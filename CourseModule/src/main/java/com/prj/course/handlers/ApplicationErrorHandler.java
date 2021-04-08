package com.prj.course.handlers;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prj.course.exception.CourseNotFoundExceotion;
import com.prj.course.exception.DuplicateCourseException;
import com.prj.course.exception.EmptytableException;


@ControllerAdvice
public class ApplicationErrorHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorList=
		ex.getBindingResult()
		.getFieldErrors()
		.stream()
		.map(fe->fe.getDefaultMessage())
		.collect(Collectors.toList());
		
		Map<String,Object> errorBody=new LinkedHashMap<>();
		errorBody.put("Dataerror","prblem in data recieved");
		errorBody.put("timestamp",LocalDateTime.now());
		errorBody.put("errors",errorList);
		
		return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(DuplicateCourseException.class)
	public ResponseEntity<?> handleDuplicateEntity(DuplicateCourseException ex){
		Map<String,Object> errorBody=new LinkedHashMap<>();
		errorBody.put("error", "creation failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());		
		return new ResponseEntity<>(errorBody,HttpStatus.BAD_REQUEST);
		
	}
@ExceptionHandler(EmptytableException.class)
public ResponseEntity<?> handleEmptyData(EmptytableException ex){
	Map<String,Object> errorBody=new LinkedHashMap<>();
	errorBody.put("error", "Table dosent exist");
	errorBody.put("timestamp", LocalDateTime.now());
	errorBody.put("details", ex.getMessage());
	
	return new ResponseEntity<>(errorBody,HttpStatus.NOT_FOUND);
	}
@ExceptionHandler(CourseNotFoundExceotion.class)
public ResponseEntity<?> handleMissingCourse(CourseNotFoundExceotion ex){
	Map<String,Object> errorBody=new LinkedHashMap<>();
	errorBody.put("error", ex.getOperation());
	errorBody.put("timestamp", LocalDateTime.now());
	errorBody.put("details", ex.getMessage());
	
	return new ResponseEntity<>(errorBody,HttpStatus.NOT_FOUND);
	
}
}
