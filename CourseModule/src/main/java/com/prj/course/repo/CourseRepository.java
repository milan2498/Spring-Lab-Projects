package com.prj.course.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.prj.course.dto.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer>{
	
	
}
