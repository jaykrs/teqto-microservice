package com.teqto.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teqto.course.entity.Chapter;

public interface UnitRepository extends JpaRepository<Chapter, Integer>{

}
