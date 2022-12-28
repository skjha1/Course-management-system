package com.example.funproj.dao;

import com.example.funproj.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {

}
