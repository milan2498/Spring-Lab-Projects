package com.prj.course.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prj.course.dto.Course;
import com.prj.course.exception.DuplicateCourseException;
import com.prj.course.repo.CourseRepository;


@Component("jpaDao")
public class CourseJpaDaoImpl implements CourseDao{
	@Autowired
	CourseRepository repository;

	@Override
	public void save(Course c) throws DuplicateCourseException {
		if(repository.existsById(c.getCourseId()))
			throw new DuplicateCourseException("Course with"+c.getCourseId()+"Already exists");
		repository.save(c);
		
	}

	@Override
	public boolean update(Course c) {
		if(repository.existsById(c.getCourseId())) {
			repository.save(c);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		if(repository.existsById(id))
			repository.deleteById(id); 
		return false;
	}

	@Override
	public Course getCourse(int id) {
		
		Optional<Course> opt = repository.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> list=(List<Course>) repository.findAll();
		return list;
	}

}
