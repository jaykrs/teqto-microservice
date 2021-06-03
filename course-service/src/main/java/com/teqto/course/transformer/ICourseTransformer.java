package com.teqto.course.transformer;

import com.teqto.course.entity.Chapter;
import com.teqto.course.entity.Course;
import com.teqto.course.entity.Unit;
import com.teqto.course.model.FormChapter;
import com.teqto.course.model.FormCourse;
import com.teqto.course.model.FormUnit;

public interface ICourseTransformer {

	public Course courseTransformer(FormCourse formCourse);
	public FormCourse courseTransformer(Course course);
	
	public Unit unitTransformer(FormUnit formUnit);
	public FormUnit unitTransformer(Unit unit);
	
	public Chapter chapterTransformer(FormChapter formChapter);
	public FormChapter chapterTransformer(Chapter chapter);
}
