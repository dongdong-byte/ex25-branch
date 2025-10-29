package com.kim.ex25_branch.service;



import com.kim.ex25_branch.domain.StudentTest;
import com.kim.ex25_branch.mapper.StudentMapperTest02;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentServiceTest02 {
    @Autowired
    private StudentMapperTest02 studentMapperTest02;


    @Test
    @DisplayName("학생 이름을 등록후 조회좍인ㄹ")
    void testRegisterAndFind(){





    }

    @Test
    @DisplayName("학생 전체 조회 TDD")
    void testRegisterAndFindTdd() {
        // given
        StudentTest s3 = StudentTest.builder().name("홍길동3").email("hong3@test.com").age(23).build();
        StudentTest s4 = StudentTest.builder().name("홍길동4").email("hong4@test.com").age(24).build();
        studentMapperTest02.insert(s3);
        studentMapperTest02.insert(s4);

        // when
        List<StudentTest> students = studentMapperTest02.findAll();

        // then
        assertTrue(students.size() >= 2);
        // 스스로 수정해보자
        // assertEquals("김철수", students.get(0).getName()); // 최신순
        assertEquals("이영희", students.get(0).getName()); // 최신순
    }
}
