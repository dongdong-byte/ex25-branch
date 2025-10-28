package com.kim.ex25_branch.service;


<<<<<<< HEAD
import com.kim.ex25_branch.domain.Student;
=======
import com.kim.student.domain.Student;
>>>>>>> f2/vaild
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = StudentService.class)
public class StudentServiceTest {
    @Autowired
    private  StudentService studentService;
    @Test
    void 학생_등록_성공(){
//        given
        Student student = new Student();
        student.setName("테스트 학생");
        student.setAge(30);
        student.setEmail("test123@test.com");
//        when
        studentService.createStudent(student);
//        then
        assertNotNull(student.getId());
        System.out.println("생성된 ID : " + student.getId());


    }

    @Test
    void 전체_조회_테스트(){
//        when
        List<Student> students = studentService.getAllStudents();
//        then
        assertNotNull(students);
        System.out.println("학생수 : " + students.size());
        students.forEach(s -> System.out.println(" - " + s.getName()));

    }
    @Test
    void 이름_필수_검증(){
//        given
        Student student = new Student();
        student.setEmail("test@test.com");
        student.setAge(30);
//        when&then
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentService.createStudent(student)
        );
        System.out.println("예외 메세지 : " + exception.getMessage());
        assertTrue(exception.getMessage().contains("이름은 필수"));



    }
    @Test
    void  나이_범위_검증(){
//        given
        Student student = new Student();
        student.setName("테스트");
        student.setEmail("test@test.com");
        student.setAge(-15);
//when&then
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentService.createStudent(student)
        );
        System.out.println("예외 메세지 : " + exception.getMessage());
        assertTrue(exception.getMessage().contains("나이"));

    }

}
