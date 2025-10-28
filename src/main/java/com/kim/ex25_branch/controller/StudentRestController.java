package com.kim.ex25_branch.controller;


import com.kim.ex25_branch.domain.*;
import com.kim.ex25_branch.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 학생 관리 REST API 컨트롤러
 *
 * 💡 비유: 배달 전문점
 * - JSON 형태로 데이터 주고받기
 * - 모바일 앱, 다른 서버와 통신용
 * - RESTful API 설계 원칙 준수
 *
 * ✅ REST API 설계:
 * GET    /api/students      → 전체 조회
 * GET    /api/students/{id} → 단건 조회
 * POST   /api/students      → 등록
 * PUT    /api/students/{id} → 수정
 * DELETE /api/students/{id} → 삭제
 */

@RestController("day1026StudentRestController")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentRestController {
    private final StudentService studentService;

    //1.전체 학생 조회
//    GET/api/students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        log.info("api: 전체 학생조회 요청");
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
//    2.특정 학생 조회
//    GET/api/students?{id}
@GetMapping("/{id}")
public ResponseEntity<Student > getStudent(@PathVariable Long id){
        log.info("API: 학생 조회 요청 - ID: {}", id);
try {
    Student student = studentService.getStudent(id);
    return ResponseEntity.ok(student);
}catch (Exception e) {
    log.warn("학생을 찾을수 없음 - ID : {}",id);
    return  ResponseEntity.notFound().build();

}

}
//3.학생 등록
//  Post/  api/students
@PostMapping
    public  ResponseEntity<Student>createStudent(@Valid @RequestBody Student student){
    log.info("API: 학생 등록 요청 - Name: {}", student.getName());
    try {
        studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }catch (Exception e) {
        log.error("학생등록 실패",e);
        return  ResponseEntity.badRequest().build();

    }

}
//    학생 수정
//    Put/api/students/{id}

    @PutMapping("/{id}")
    public  ResponseEntity<Student>updateStudent(@PathVariable Long id ,
                                                 @Valid @RequestBody Student student){
        log.info("API: 학생  수정 요청 - ID: {}", id);
         try {
             student.setId(id);
             studentService.updateStudent(student);
//             성공시 return문 추가
             return ResponseEntity.ok(student);
         }catch (IllegalArgumentException e){
             log.warn("API: 학생을 찾을수 없음 - ID: {}", id);
             return ResponseEntity.notFound().build();
         }catch (Exception e) {
             log.error("학생 수정실패 " ,e);
             return ResponseEntity.badRequest().build();
         }

    }

//    5. 학생 삭제

    @DeleteMapping("/{id}")
    public  ResponseEntity<Student>deleteStudent(@PathVariable Long id){
        log.info("API: 학생  삭제 요청 - ID: {}", id);
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e){
            log.warn("API: 학생을 찾을수 없음 - ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }
}
