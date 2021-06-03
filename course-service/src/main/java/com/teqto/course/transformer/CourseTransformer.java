package com.teqto.course.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teqto.course.entity.Chapter;
import com.teqto.course.entity.Course;
import com.teqto.course.entity.Unit;
import com.teqto.course.model.FormChapter;
import com.teqto.course.model.FormCourse;
import com.teqto.course.model.FormUnit;
import com.teqto.course.repository.ChapterRepository;
import com.teqto.course.repository.CourseRepository;
import com.teqto.course.repository.UnitRepository;

@Repository(value = "courseTransformer")
public class CourseTransformer implements ICourseTransformer{

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	UnitRepository unitRepository;
	
	@Autowired
	ChapterRepository chapterRepository;
	
	public Course courseTransformer(FormCourse formCourse) {
		Course course = null;
		if(formCourse.getId() > 0 )
			course = courseRepository.getById(formCourse.getId());	
		else {	
		course = new Course();
		course.setTitle(formCourse.getTitle());
		course.setName(formCourse.getName());
		course.setDescription(formCourse.getDescription());
		course.setCourseBaseLanguage(formCourse.getCourseBaseLanguage());
		course.setCourseSecondaryLanguage(formCourse.getCourseSecondaryLanguage());
		course.setCourseCatagory(formCourse.getCourseCatagory());
		course.setCourseType(formCourse.getCourseType());
		course.setRequirement(formCourse.getRequirement());
		course.setCourseCurrency(formCourse.getCourseCurrency());
		course.setCourseFee(formCourse.getCourseFee());
		course.setCourseDiscountPc(formCourse.getCourseDiscountPc());
		course.setAudiance(formCourse.getAudiance());
		course.setCourseIntroPath(formCourse.getCourseIntroPath());
		course.setCourseLogoPathBig(formCourse.getCourseLogoPathBig());
		course.setCourseLogoPathSmall(formCourse.getCourseLogoPathSmall());
		}
	return course;
	};
	
	public FormCourse courseTransformer(Course course) {
		FormCourse formCourse = new FormCourse();
		formCourse.setId(course.getId());
		formCourse.setTitle(course.getTitle());
		formCourse.setName(course.getName());
		formCourse.setDescription(course.getDescription());
		formCourse.setCourseBaseLanguage(course.getCourseBaseLanguage());
		formCourse.setCourseSecondaryLanguage(course.getCourseSecondaryLanguage());
		formCourse.setCourseCatagory(course.getCourseCatagory());
		formCourse.setCourseType(course.getCourseType());
		formCourse.setRequirement(course.getRequirement());
		formCourse.setCourseCurrency(course.getCourseCurrency());
		formCourse.setCourseFee(course.getCourseFee());
		formCourse.setCourseDiscountPc(course.getCourseDiscountPc());
		formCourse.setAudiance(course.getAudiance());
		formCourse.setCourseIntroPath(course.getCourseIntroPath());
		formCourse.setCourseLogoPathBig(course.getCourseLogoPathBig());
		formCourse.setCourseLogoPathSmall(course.getCourseLogoPathSmall());
	return formCourse;
	}

	@Override
	public Unit unitTransformer(FormUnit formUnit) {
		Unit unit = null;
		if(formUnit.getId() > 0) 
			unit = unitRepository.getById(formUnit.getId());
		else {
		Course course = courseRepository.getById(formUnit.getCourseId());
		unit = new Unit();
		unit.setUnitTitle(formUnit.getUnitTitle());
		unit.setUnitDuration(formUnit.getUnitDuration());
		unit.setUnitBrief(formUnit.getUnitBrief());
		unit.setOrderCount(formUnit.getOrderCount());
		unit.setMetadata(formUnit.getMetadata());
		unit.setIntroductoryVideo(formUnit.getIntroductoryVideo());
		unit.setCourse(course);
		}
		return unit;
	}

	@Override
	public FormUnit unitTransformer(Unit unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chapter chapterTransformer(FormChapter formChapter) {
		Chapter chapter = null;
		if(formChapter.getId() > 0) 
			chapter = chapterRepository.getById(formChapter.getId());
		else {
			chapter = new Chapter();
			Unit unit = unitRepository.getById(formChapter.getUnitId());
			chapter.setMetadata(formChapter.getMetadata());
			chapter.setChapterType(formChapter.getChapterType());
			chapter.setChapterTitle(formChapter.getChapterTitle());
			chapter.setChapterResource(formChapter.getChapterResource());
			chapter.setChapterOrder(formChapter.getChapterOrder());
			chapter.setChapterDuration(formChapter.getChapterDuration());
			chapter.setChapterContent(formChapter.getChapterContent());
			chapter.setChapterBrief(formChapter.getChapterBrief());
			chapter.setUnit(unit);
			chapter.setCourseId(formChapter.getCourseId());
		}
		return chapter;
	}

	@Override
	public FormChapter chapterTransformer(Chapter chapter) {
		// TODO Auto-generated method stub
		return null;
	};
}
