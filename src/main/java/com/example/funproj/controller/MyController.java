package com.example.funproj.controller;


import com.example.funproj.entities.Course;
import com.example.funproj.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MyController{
    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home(){
        return "This is a demo class! Welcome to Demo class!! ";
    }
    // Get the courses


    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }
    // Single course get
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this .courseService.getCourse(Long.parseLong(courseId));
    }
    // course add
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }
    // update course using PUT request
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    // delete the course
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse (@PathVariable String courseId){
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
