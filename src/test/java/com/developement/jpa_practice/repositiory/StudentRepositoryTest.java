package com.developement.jpa_practice.repositiory;

import com.developement.jpa_practice.entity.Guardian;
import com.developement.jpa_practice.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
        @Autowired
        private StudentRepository studentRepository;
        @Test
        public void addStudent() {
            Guardian guardian = Guardian.builder()
                    .name("Guardian")
                    .email("Guardian@gmail.com")
                    .mobile("9900990044")
                    .build();
            Student student = Student.builder()
                    .firstName("Akram")
                    .lastName("Gilani")
                    .emailId("akram@gmail.com")
                    .guardian(guardian)
                    .build();
            studentRepository.save(student);
        }

        @Test
        public void getAllStudents(){
            List<Student> students = studentRepository.findAll();
            System.out.println("students = " + students);
        }

        @Test
        public void getStudentByFirstName(){
            List<Student> list = studentRepository.findByFirstName("shadab");
            System.out.println("list of students = " + list);
        }

        @Test
        public void getStudentByFirstNameContaining(){
            List<Student> listOfStudents = studentRepository.findByFirstNameContaining("Shadab");
            System.out.println("listOfStudents = " + listOfStudents);
        }

        @Test
        public void getStudentByEmailAddress(){
            Student student = studentRepository.getStudentByEmailAddress("akram@gmail.com");
            System.out.println("student = " + student);
        }

        @Test
        public void getStudentFirstNameByEmailNative(){
            String studentFirstName = studentRepository.getStudentFirstNameByEmail("Shadab@gmail.com");
            System.out.println("studentFirstName = " + studentFirstName);
        }
        
        @Test
        public void getGuardianNameByStudentEmail(){
            String guardianName = studentRepository.getStudentGuardianNameByStudentEmail("Shadab@gmail.com");
            System.out.println("guardianName = " + guardianName);
        }
}