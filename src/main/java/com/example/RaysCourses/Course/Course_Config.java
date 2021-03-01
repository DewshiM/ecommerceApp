package com.example.RaysCourses.Course;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Course_Config {
    @Bean
    CommandLineRunner courseCommandLineRunner(Course_Repository courseRepository) {
        return args -> {
            Course image_processing = new Course("Image Processing");
            Course database = new Course("Database");

           courseRepository.saveAll(
                   List.of(image_processing,database));
        };
    }
}
