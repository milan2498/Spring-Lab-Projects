package com.prj.course.exception;

public class DuplicateCourseException extends RuntimeException{
	public DuplicateCourseException(String msg) {
		super(msg);
	}
}
