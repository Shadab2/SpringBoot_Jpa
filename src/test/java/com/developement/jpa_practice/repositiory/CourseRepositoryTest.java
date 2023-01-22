package com.developement.jpa_practice.repositiory;

import com.developement.jpa_practice.entity.Course;
import com.developement.jpa_practice.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    @Transactional
    public void saveCourseMaterial(){
        Course course = courseRepository.getReferenceById(1l);
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(course)
                .url("http://learnenglish.com")
                .build();
        CourseMaterial courseMaterial1 = courseMaterialRepository.save(courseMaterial);
        System.out.println("courseMaterial1 = " + courseMaterial1);
    }

    @Test
    public void saveCourseMaterialWithCourse(){
        Course course = Course.builder()
                .title("Data Structures and Algorithms")
                .credit(5)
                .title("DSA")
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(course)
                .url("http://dsa.com")
                .build();
        CourseMaterial courseMaterial1 = courseMaterialRepository.save(courseMaterial);
        System.out.println("courseMaterial1 = " + courseMaterial1);

    }
    @Test
    public void saveCourse(){
        Course course = Course.builder()
                .title("English Honors")
                .credit(4)
                .title("English")
                .build();
        Course savedCourse = courseRepository.save(course);
        System.out.println("savedCourse = " + savedCourse);
    }
}