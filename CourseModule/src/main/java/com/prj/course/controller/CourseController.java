package com.prj.course.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prj.course.dto.Course;
import com.prj.course.exception.CourseNotFoundExceotion;
import com.prj.course.exception.EmptytableException;
import com.prj.course.service.CourseService;


@RestController
@RequestMapping("course")
public class CourseController {
	Logger logger=LoggerFactory.getLogger(CourseController.class);
	@Autowired
	CourseService service;
	
	@GetMapping("{cid}")
	public ResponseEntity<?> getCourse(@PathVariable("cid") int courseId) {
		Course c=service.get(courseId);
		if (c==null)
			throw new CourseNotFoundExceotion("Request Failed", "Course with id "+courseId+"not found");
		return new ResponseEntity<Course>(c,HttpStatus.OK);
		}
	@GetMapping
	public List<Course> getAllCourse(){
		List<Course> list=  service.getAll();
		if(list.size()==0)
			throw new EmptytableException("No Courses in database");
		return list;	
	}
	@PostMapping
	public String saveCourse(@Valid @RequestBody Course c) {
		service.add(c);
			return "Course successsfully added";	
	}
	
	@PutMapping
	public String updateCourse(@Valid @RequestBody Course c) {
		if(service.update(c))
			return "data updated";
		else
			throw new CourseNotFoundExceotion("Update failed","Course with id"+c.getCourseId()+"not found");
	}
	@DeleteMapping("{cid}")
	public String deleteCourse(@PathVariable("cid") int id) {
		if(service.delete(id))
			return "data deleted";
		else
			throw new CourseNotFoundExceotion("Delete Failed","Course with id to delete "+ id+"not found");
	}

}
