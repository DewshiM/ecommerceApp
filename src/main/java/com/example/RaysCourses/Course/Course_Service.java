package com.example.RaysCourses.Course;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Course_Service {
    private Course_Repository courseRepository;

    public Course_Service(Course_Repository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
}
