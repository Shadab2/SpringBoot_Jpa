package com.developement.jpa_practice.repositiory;

import com.developement.jpa_practice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository  extends JpaRepository<Course,Long> {
}
