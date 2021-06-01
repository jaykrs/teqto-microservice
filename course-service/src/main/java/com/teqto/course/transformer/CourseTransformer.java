package com.teqto.course.transformer;

import org.springframework.stereotype.Repository;

import com.teqto.course.entity.Course;
import com.teqto.course.model.FormCourse;

@Repository(value = "courseTransformer")
public class CourseTransformer implements ICourseTransformer{

	public Course courseTransformer(FormCourse formCourse) {
		Course course = new Course();
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
		
		course.setPublishStatus(formCourse.getPublishStatus());
	return course;
	};
	
	public FormCourse courseTransformer(Course course) {
		FormCourse formCourse = new FormCourse();
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
		
		formCourse.setPublishStatus(course.getPublishStatus());
	return formCourse;
	};
}
