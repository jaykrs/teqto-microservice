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

import com.teqto.course.entity.Chapter;
import com.teqto.course.entity.Course;
import com.teqto.course.model.FormChapter;
import com.teqto.course.repository.ChapterRepository;
import com.teqto.course.repository.CourseRepository;
import com.teqto.course.repository.UnitRepository;
import com.teqto.course.transformer.ICourseTransformer;
@RestController
@RequestMapping("/api/chapter")
public class ChapterController{

	@Autowired
	UnitRepository unitRepository;
	
	@Autowired
	ChapterRepository chapterRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	ICourseTransformer courseTransformer;
	
	@GetMapping("/public/{chapterId}")
	ResponseEntity<Chapter> addCourse(@PathVariable("chapterId") int chapterId) {		
		return new ResponseEntity<Chapter>(chapterRepository.findById(chapterId).get(), HttpStatus.OK);
	}
	
	@RequestMapping (method = RequestMethod.POST) 
	ResponseEntity<Chapter> addChapter(@Valid @RequestBody FormChapter formChapter) {
		Chapter chapter = null;
		if (null != formChapter) {
			Course course = courseRepository.getById(formChapter.getCourseId());
			course.setApprovalStatus(Boolean.FALSE);
			course.setPublishStatus(Boolean.FALSE);
			course.setModifiedDate(new Date());
			courseRepository.save(course);
			chapter = chapterRepository.save(courseTransformer.chapterTransformer(formChapter));
		}
		return new ResponseEntity<>(chapter, HttpStatus.OK);
	}
	
	@RequestMapping (method = RequestMethod.PUT) 
	ResponseEntity<Chapter> updateUnit(@Valid @RequestBody Chapter chapter) {
		if (null != chapter) {
			Course course = courseRepository.findById(chapter.getCourseId()).get();
			course.setApprovalStatus(Boolean.FALSE);
			course.setPublishStatus(Boolean.FALSE);
			course.setModifiedDate(new Date());
			courseRepository.save(course);
			chapter = chapterRepository.save(chapter);
		}
		return new ResponseEntity<>(chapter, HttpStatus.OK);
	}
			
}
