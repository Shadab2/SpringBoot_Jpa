package com.developement.jpa_practice.repositiory;

import com.developement.jpa_practice.entity.Course;
import com.developement.jpa_practice.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void save(){
       Course course  = Course.builder()
               .title("Phsyics")
               .credit(6)
               .build();

        Teacher teacher = Teacher.builder()
                .firstName("Professor")
                .lastName("Khurana")
                .courses(List.of(course))
                .build();
        course.setTeacher(teacher);

        Teacher savedTeacher = teacherRepository.save(teacher);
        System.out.println("savedTeacher = " + savedTeacher);

    }

    @Test
    public void printAllTeacher(){
        List<Teacher> teacherList = teacherRepository.findAll();
        System.out.println("teacherList = " + teacherList);
    }

//    @Test
//    public void printAllCourseTeachedByTeacher(){
//       List<Course> courseList = teacherRepository.findCoursesByTeacherId(13l);
//        System.out.println("courseList = " + courseList);
//    }
}