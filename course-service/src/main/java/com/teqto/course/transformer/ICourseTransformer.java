package com.teqto.course.transformer;

import com.teqto.course.entity.Course;
import com.teqto.course.model.FormCourse;

public interface ICourseTransformer {

	public Course courseTransformer(FormCourse formCourse);
	public FormCourse courseTransformer(Course course);
}
