package com.teqto.course.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
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

import com.teqto.course.constant.AuthConstant;
import com.teqto.course.entity.Course;
import com.teqto.course.entity.User;
import com.teqto.course.model.FormCourse;
import com.teqto.course.repository.CourseRepository;
import com.teqto.course.transformer.ICourseTransformer;
import com.teqto.course.validator.IRequestValidator;
@RestController
@RequestMapping("/api/course")
public class CourseController{

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	IRequestValidator requestValidator;
	
	@Autowired
	ICourseTransformer courseTransformer;
	
	@GetMapping("/public/{courseid}")
	ResponseEntity<Course> viewCourse(@PathVariable("courseid") int courseid) {		
		return new ResponseEntity<Course>(courseRepository.findById(courseid).get(), HttpStatus.OK);
	}
	
	@RequestMapping (method = RequestMethod.POST) 
	ResponseEntity<Course> addCourse(@Valid @RequestBody FormCourse formCourse,
			HttpServletRequest request) {
		Course course = null;
		User user = requestValidator.getUserFromRequest(request);
		if (null != formCourse && null != user && (user.getUsertype().equals(AuthConstant.USER_TYPE_ADMIN)
				|| user.getUsertype().equals(AuthConstant.USER_TYPE_VENDOR))) {
			course = courseTransformer.courseTransformer(formCourse);
			course.setCreatedDate(new Date());
			if (user.getUsertype().equals(AuthConstant.USER_TYPE_VENDOR))
				course.setCourseModerator(user.getUserid());
			course.setApprovalStatus(Boolean.FALSE);
			course.setPublishStatus(Boolean.FALSE);
			course = courseRepository.save(course);
		}
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@RequestMapping (method = RequestMethod.PUT) 
	ResponseEntity<Course> updateCourse(@Valid @RequestBody Course course, HttpServletRequest request) {
		User user = requestValidator.getUserFromRequest(request);
		if (null != course && null != user && (user.getUsertype().equals(AuthConstant.USER_TYPE_ADMIN)
				|| user.getUsertype().equals(AuthConstant.USER_TYPE_VENDOR))) {
			course.setApprovalStatus(Boolean.FALSE);
			course.setPublishStatus(Boolean.FALSE);
			course.setModifiedDate(new Date());
			course.setModifiedBy(user.getUserid());
			course = courseRepository.save(course);
		}
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
			
}
