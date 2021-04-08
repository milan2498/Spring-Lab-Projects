package com.prj.course.service;

import java.util.List;

import com.prj.course.dto.Course;


public interface CourseService {
	Course get(int id);
	List<Course> getAll();
	boolean add( Course c);
	boolean update(Course c);
	boolean delete(int id);

}
