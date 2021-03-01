package com.example.RaysCourses.University;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface University_Repository extends JpaRepository<University,Long> {
}
