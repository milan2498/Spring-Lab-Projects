package com.prj.course.exception;

public class CourseNotFoundExceotion extends RuntimeException {
	private String operation;
	public CourseNotFoundExceotion(String operation ,String message) {
		super(message);
		this.operation=operation;
		
		
	}
	public String getOperation() {
		return operation;
	}

}
