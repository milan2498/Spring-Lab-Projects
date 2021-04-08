package com.prj.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.prj.course.dao.CourseDao;
import com.prj.course.dto.Course;
import com.prj.course.exception.DuplicateCourseException;


@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	@Qualifier("jpaDao")
	CourseDao dao;
	
	@Override
	public Course get(int id) {
		return dao.getCourse(id);
	}
	
	@Override
	public List<Course> getAll() {
		return dao.getAllCourses();
	}
	
	@Override
	public boolean add(Course c) {
		try {
			dao.save(c);
			return true;
		}catch(DuplicateCourseException e1) {
		return false;
		}	
	}

	@Override
	public boolean update(Course c) {
		return dao.update(c);
	}

	@Override
	public boolean delete(int id) {
		return dao.delete(id);
	}

}
