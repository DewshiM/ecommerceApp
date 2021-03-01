package com.example.RaysCourses.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Course_Repository extends JpaRepository<Course, Long> {

}
