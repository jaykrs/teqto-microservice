package com.teqto.course.controller;

import java.util.Date;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teqto.course.entity.Course;
import com.teqto.course.model.FormCourse;
import com.teqto.course.repository.CourseRepository;
import com.teqto.course.transformer.ICourseTransformer;
@RestController
@RequestMapping("/api/course")
public class CourseController{

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	ICourseTransformer courseTransformer;
	
	@GetMapping("/public/{courseid}")
	ResponseEntity<Course> addCourse(@PathVariable("courseid") int courseid) {		
		return new ResponseEntity<Course>(courseRepository.findById(courseid).get(), HttpStatus.OK);
	}
	
	@RequestMapping (method = RequestMethod.POST) 
	ResponseEntity<Course> addCourse(@Valid @RequestBody FormCourse formCourse) {
		Course course = null;
		if (null != formCourse) {
			course = courseTransformer.courseTransformer(formCourse);	
			course.setCreatedDate(new Date());
			course = courseRepository.save(course);
		}
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@RequestMapping (method = RequestMethod.PUT) 
	ResponseEntity<Course> updateCourse(@Valid @RequestBody Course course) {
		if (null != course) {
			course = courseRepository.save(course);
		}
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
			
}
