package com.example.RaysCourses.University;

import com.example.RaysCourses.Course.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class University_Service {
    private University_Repository universityRepository;

    public University_Service(University_Repository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<University> getUniversities() {
        return universityRepository.findAll();
    }
}
