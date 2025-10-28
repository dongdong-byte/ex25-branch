package com.kim.ex25_branch.mapper;

import com.kim.ex25_branch.domain.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@DisplayName("학생 매퍼 테스트")
public class StudentMapperTest {
    @Autowired
    StudentMapper mapper;

//    given(주어진상황)
//    when(실행)
//    thens(검증)

    @Test
    @DisplayName("전체 학생 조회 테스트")
    void testFindAll(){
//        given

//        when
        List<Student> students = mapper.findAll();
//        then
        assertThat(students).isNotNull();
        assertThat(students.size()).isGreaterThanOrEqualTo(0);
        System.out.println("학생수 : " +students.size() );

    }

    @Test
    @DisplayName(" 학생 생성 테스트")
    void  testCreate(){
//        given
        Student student = Student.builder()
                .name("테스트이름")
                .email("test@test.com")
                .age(100)
                .build();

//        when
        mapper.create(student);
//        then
        assertThat(student.getId()).isNotNull();
        assertThat(student.getId()).isGreaterThan(0L);


//        Student student = new Student();
//        student.setName("테스트이름");
//        student.setEmail("test@test.com");
//        student.setAge(100);


        System.out.println("생성된 ID :" + student.getId());
    }
}
