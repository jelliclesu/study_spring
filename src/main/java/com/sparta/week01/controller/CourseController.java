package com.sparta.week01.controller;

import com.sparta.week01.prac.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @GetMapping("/courses")
    public Course getCourse() {
        Course course = new Course();
        course.setTitle("Spring");
        course.setDays(5);
        course.setTutor("Tom");
        return course;
    }
}
