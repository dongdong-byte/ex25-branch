package com.kim.ex25_branch.controller;


<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.kim.ex25_branch.domain.Student;
import com.kim.ex25_branch.service.StudentService;
=======
import com.kim.student.domain.Student;
import com.kim.student.service.StudentService;
>>>>>>> f2/vaild
=======
import com.kim.student.domain.Student;
import com.kim.student.service.StudentService;
>>>>>>> f2/vaild
=======
import com.kim.ex25_branch.domain.Student;
import com.kim.ex25_branch.service.StudentService;
>>>>>>> f2/dbconn
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * StudentController 단위 테스트
 *
 * 💡 비유: 식당 카운터 직원 교육 시뮬레이션
 * - 실제 주방(Service)은 가짜(Mock)
 * - 카운터 직원(Controller)만 테스트
 * - 빠르고 안전하게 테스트 가능
 *
 * ✅ Spring Boot 3.4.0+ 최신 방식:
 *  * @ExtendWith(MockitoExtension.class): Mockito 확장 사용
 *  * @Mock: 가짜 객체 생성 (구 @MockBean)
 *  * @InjectMocks: Mock 객체를 자동 주입
 *  *
 *  * 장점:
 *  * - Spring 컨텍스트 로드 안 해도 됨 (매우 빠름!)
 *  * - 순수 단위 테스트
 *  * - 더 가볍고 독립적
 */


@ExtendWith(MockitoExtension.class)
@DisplayName("StudentController  단위 테스트")
public class StudentControllerTest {


    private MockMvc mockMvc;
    @Mock
    private StudentService studentService;

    @InjectMocks
    private  StudentController studentController;
    private Student testStudent;
    private List<Student> testStudentList;

//    각 테스트 실행전 준비
    @BeforeEach
    void setUp() {
//        MockMvc 수동설정 (spring 없이 컨트롤러만 테스트)
// MockMvcBuilders 하고 MockMvcBuilder 는 다르다
mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
//테스트용 학생 데이터 준비
        testStudent = Student.builder()
                .id(1L)
                .name("테스트 이름")
                .age(99)
                .email("test@test.com")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        testStudentList =Arrays.asList(
                testStudent,
                Student.builder()
                        .id(2L)
                        .name("테스트 2호기")
                        .email("kim@test.com")
                        .age(88)
                        .build()
        );
    }
    @Test
    @DisplayName("목록 조회 성공")
    void  testList()throws  Exception{
//        given: Service가 학생 목록을 반환하도록 설정
        when(studentService.getAllStudents()).thenReturn(testStudentList);
//    when&then get/studentfinal요청
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        mockMvc.perform(get("/templates/student"))
                .andDo(print())//  요청 응답 출력
                .andExpect(status().isOk())//200 오케이
                .andExpect(view().name("templates/student/list"))//뷰 이름확인
=======
=======
>>>>>>> f2/vaild
        mockMvc.perform(get("/studentfinal"))
                .andDo(print())//  요청 응답 출력
                .andExpect(status().isOk())//200 오케이
                .andExpect(view().name("studentfinal/list"))//뷰 이름확인
<<<<<<< HEAD
>>>>>>> f2/vaild
=======
>>>>>>> f2/vaild
=======
        mockMvc.perform(get("/templates/student"))
                .andDo(print())//  요청 응답 출력
                .andExpect(status().isOk())//200 오케이
                .andExpect(view().name("templates/student/list"))//뷰 이름확인
>>>>>>> f2/dbconn
                .andExpect(model().attributeExists("students"))//  속성존재확인
                .andExpect(model().attribute("students",testStudentList));// 데이터 확인
//   verify : Service 메서드가 1번 호출 되었는지 확인
        verify(studentService ,times(1)).getAllStudents();
    }
    @Test
    @DisplayName("등록 폼 조회 - 성공")
    void  testCreateForm() throws  Exception{
//        when&then
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        mockMvc.perform(get("/templates/student/new"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("templates/student/form"))
                .andExpect(model().attributeExists("templates/student"));
=======
=======
>>>>>>> f2/vaild
        mockMvc.perform(get("/studentfinal/new"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("studentfinal/form"))
                .andExpect(model().attributeExists("student"));
<<<<<<< HEAD
>>>>>>> f2/vaild
=======
>>>>>>> f2/vaild
=======
        mockMvc.perform(get("/templates/student/new"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("templates/student/form"))
                .andExpect(model().attributeExists("templates/student"));
>>>>>>> f2/dbconn
}

    @Test
    @DisplayName("수정폼 조회 - 성공")
    void  testEditForm_Success() throws  Exception{
//        given
        when(studentService.getStudent(1L)).thenReturn(testStudent);
//            when & then
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        mockMvc.perform(get("/templates/student/1/edit"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("templates/student/form"))
                .andExpect(model().attribute("templates/student",testStudent));
=======
=======
>>>>>>> f2/vaild
        mockMvc.perform(get("/studentfinal/1/edit"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("studentfinal/form"))
                .andExpect(model().attribute("student",testStudent));
<<<<<<< HEAD
>>>>>>> f2/vaild
=======
>>>>>>> f2/vaild
=======
        mockMvc.perform(get("/templates/student/1/edit"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("templates/student/form"))
                .andExpect(model().attribute("templates/student",testStudent));
>>>>>>> f2/dbconn
        verify(studentService).getStudent(1L);
    }

    @Test
    @DisplayName("학생 등록 - 성공")
    void  testSave_Create() throws  Exception{
//       given
        doNothing().when(studentService).createStudent(any(Student.class));
//    when&then
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        mockMvc.perform(post("/templates/student")
=======
        mockMvc.perform(post("/studentfinal")
>>>>>>> f2/vaild
=======
        mockMvc.perform(post("/studentfinal")
>>>>>>> f2/vaild
=======
        mockMvc.perform(post("/templates/student")
>>>>>>> f2/dbconn
                        .param("name","테스트이름")
                        .param("age","99")
                        .param("email","test@test.com"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                .andExpect(redirectedUrl("/templates/student"));
=======
                .andExpect(redirectedUrl("/studentfinal"));
>>>>>>> f2/vaild
=======
                .andExpect(redirectedUrl("/studentfinal"));
>>>>>>> f2/vaild
=======
                .andExpect(redirectedUrl("/templates/student"));
>>>>>>> f2/dbconn
        verify(studentService).createStudent(any(Student.class));

    }
    @Test
    @DisplayName("학생 수정 - 성공")
    void  testSave_Update()throws Exception{
//        given
        doNothing().when(studentService).updateStudent(any(Student.class));
//    when&then
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        mockMvc.perform(post("/templates/student")
=======
        mockMvc.perform(post("/studentfinal")
>>>>>>> f2/vaild
=======
        mockMvc.perform(post("/studentfinal")
>>>>>>> f2/vaild
=======
        mockMvc.perform(post("/templates/student")
>>>>>>> f2/dbconn
                        .param("id","1")
                        .param("name" ," 수정된이름")
                        .param("age","77"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                .andExpect(redirectedUrl("/templates/student"));
=======
                .andExpect(redirectedUrl("/studentfinal"));
>>>>>>> f2/vaild
=======
                .andExpect(redirectedUrl("/studentfinal"));
>>>>>>> f2/vaild
=======
                .andExpect(redirectedUrl("/templates/student"));
>>>>>>> f2/dbconn
        verify(studentService).updateStudent(any(Student.class));

    }
@Test
    @DisplayName("학생 삭제 성공")
    void  testDelete_Delete() throws Exception{
//        given
//    getstudent mock 설정추가
    doNothing().when(studentService).deleteStudent(1L);
    when(studentService.getStudent(1L)).thenReturn(testStudent);
//    when & then
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    mockMvc.perform(post("/templates/student/1/delete"))
            .andDo(print())
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/templates/student"));
=======
=======
>>>>>>> f2/vaild
    mockMvc.perform(post("/studentfinal/1/delete"))
            .andDo(print())
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/studentfinal"));
<<<<<<< HEAD
>>>>>>> f2/vaild
=======
>>>>>>> f2/vaild
=======
    mockMvc.perform(post("/templates/student/1/delete"))
            .andDo(print())
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/templates/student"));
>>>>>>> f2/dbconn

        verify(studentService).deleteStudent(1L);
}

}
