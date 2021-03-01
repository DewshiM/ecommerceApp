package com.example.RaysCourses.University;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class University_Controller {
    private University_Service universityService;

    @Autowired
    public University_Controller(University_Service universityService) {
        this.universityService = universityService;
    }
}
