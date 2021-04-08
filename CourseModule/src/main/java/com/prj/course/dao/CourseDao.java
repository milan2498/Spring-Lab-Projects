package com.prj.course.dao;

import java.util.List;

import com.prj.course.dto.Course;
import com.prj.course.exception.DuplicateCourseException;


public interface CourseDao {
	void save(Course c) ;
	boolean update(Course c);
	boolean delete(int id);
	Course getCourse(int id);
	List<Course> getAllCourses();

}
