package com.example.RaysCourses.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "course")
public class Course_Controller {

    private Course_Service courseService;

    @Autowired
    public Course_Controller(Course_Service courseService) {
        this.courseService = courseService;
    }


    public String getAllCourse(Model model){

        model.addAttribute("course",courseService.getCourses());

        return "Courses";
    }

    @PostMapping
    public void registerNewCourse(@RequestBody Course course){

    }

    @DeleteMapping(path = "courseId")
    public void deleteCourse(@PathVariable("courseId") Long courseId){

    }

    @PutMapping(path = "courseId")
    public void updateCourse(@PathVariable("courseId") Long courseId, @RequestBody Course course){

    }


   /*public List<Course> getCourses (){
        return courseService.getCourses();
    }*/
}
