package com.developement.jpa_practice.repositiory;

import com.developement.jpa_practice.entity.Course;
import com.developement.jpa_practice.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
