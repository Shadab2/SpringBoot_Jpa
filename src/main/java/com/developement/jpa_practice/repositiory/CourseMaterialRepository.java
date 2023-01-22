package com.developement.jpa_practice.repositiory;

import com.developement.jpa_practice.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
}
