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
import com.teqto.course.entity.Unit;
import com.teqto.course.model.FormUnit;
import com.teqto.course.repository.CourseRepository;
import com.teqto.course.repository.UnitRepository;
import com.teqto.course.transformer.ICourseTransformer;
@RestController
@RequestMapping("/api/unit")
public class UnitController{

	@Autowired
	UnitRepository unitRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	ICourseTransformer courseTransformer;
	
	@GetMapping("/public/{unitId}")
	ResponseEntity<Unit> addCourse(@PathVariable("unitId") int unitId) {		
		return new ResponseEntity<Unit>(unitRepository.findById(unitId).get(), HttpStatus.OK);
	}
	
	@RequestMapping (method = RequestMethod.POST) 
	ResponseEntity<Unit> addUnit(@Valid @RequestBody FormUnit formUnit) {
		Unit unit = null;
		if (null != formUnit) {
			Course course = courseRepository.getById(formUnit.getCourseId());
			course.setApprovalStatus(Boolean.FALSE);
			course.setPublishStatus(Boolean.FALSE);
			course.setModifiedDate(new Date());
			courseRepository.save(course);
			unit = unitRepository.save(courseTransformer.unitTransformer(formUnit));
		}
		return new ResponseEntity<>(unit, HttpStatus.OK);
	}
	
	@RequestMapping (method = RequestMethod.PUT) 
	ResponseEntity<Unit> updateUnit(@Valid @RequestBody Unit unit) {
		if (null != unit) {
			Course course = unit.getCourse();
			course.setApprovalStatus(Boolean.FALSE);
			course.setPublishStatus(Boolean.FALSE);
			course.setModifiedDate(new Date());
			courseRepository.save(course);
			unit = unitRepository.save(unit);
		}
		return new ResponseEntity<>(unit, HttpStatus.OK);
	}
			
}
