package com.example.RaysCourses.University;

import com.example.RaysCourses.Course.Course;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity(name = "University")
@Table(name = "university",
uniqueConstraints = {
        @UniqueConstraint(name = "university_name_unique",columnNames = "name")
    }
)
public class University {

    @Id
    @SequenceGenerator(
            name = "university_sequence",
            sequenceName = "university_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "university_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "name",
            nullable = false
    )
    private String Name;
    @Column(
            name = "courses"
    )
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "university_course_fk",referencedColumnName = "id")
    private List<Course> Courses = new ArrayList<>();

    public University() {
    }

    public University(String name) {
        Name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Course> getCourses() {
        return Courses;
    }

    public void setCourses(List<Course> courses) {
        Courses = courses;
    }
}
