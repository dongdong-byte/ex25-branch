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
//given
        StudentTest s1 = StudentTest.builder().name("홍길동").email("hong@test.com").build();

        StudentTest s2 = StudentTest.builder().name("홍길동2").email("hong2@test.com").build();
//when
        int result = studentMapperTest02.insert(s1);
//        then
        assertEquals(2,result,"등록은 1건 성공해야한다.");
StudentTest findStudent = studentMapperTest02.findById(s1.getId());
assertEquals("홍길동1",findStudent.getName());
    }

    @Test
    @DisplayName("학생 전체 조회 TOD")
    void testRegisterAndFindTdd() {
        // given
//        오류데이터
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
