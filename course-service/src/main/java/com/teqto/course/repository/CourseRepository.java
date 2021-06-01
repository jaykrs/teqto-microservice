package com.teqto.course.repository;

import java.net.URISyntaxException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teqto.course.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

	Optional<List<Course>> findBycourseCatagory(int catagory) throws URISyntaxException,NoSuchElementException;
}
