package com.developement.jpa_practice.repositiory;

import com.developement.jpa_practice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String student);
    public List<Student> findByFirstNameContaining(String student);

    // JPQl based on classes and objects
    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentByEmailAddress(String emailId);

    //Native query
    @Query(
            value = "Select s.first_name from student_tbl s where s.email_address = ?1",
            nativeQuery = true
    )
    public String getStudentFirstNameByEmail(String email);

    //Query Named Params
    @Query(
            value = "Select s.guardian_name from student_tbl s where s.email_address = :emailId",
            nativeQuery = true
    )
    public String getStudentGuardianNameByStudentEmail(@Param("emailId")String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update student_tbl set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    public int updateStudentFirstNameByEmailid(String firstName, String emailId);
}
