package com.example.funproj.services;
import com.example.funproj.dao.CourseDao;
import com.example.funproj.entities.Course;
import com.example.funproj.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

   // List<Course> list;

    public CourseServiceImpl(){
//        list = new ArrayList<>();
//        list.add(new Course(145,"Java","Basics of java"));
//        list.add(new Course(166,"Software Development","Basics of software developement"));
//        list.add(new Course(122,"C++","Advance of c++"));
    }

    @Override
    public List<Course> getCourses(){

        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {


//        Course c=null;
//        for (Course course:list){
//            if(course.getId()==courseId){
//                c=course;
//                break;
//            }
//        }
        return courseDao.getOne(courseId);

    }

    @Override
    @Transactional()
    public Course addCourse(Course course) {
//        list.add(course);
        return courseDao.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
//        list.forEach(e-> {
//            if(e.getId()==course.getId()){
//                e.setTitle(course.getTitle());
//                e.setDescription(course.getDescription());
//            }
//        });
        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {
        // list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
        Course entity = courseDao.getOne(parseLong);
        courseDao.delete(entity);
    }

}
