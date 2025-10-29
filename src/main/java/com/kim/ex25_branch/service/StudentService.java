package com.kim.ex25_branch.service;

import com.kim.ex25_branch.domain.Student;
import com.kim.ex25_branch.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {
    private final StudentMapper mapper;

    // 1. 전체 조회
    public List<Student> getAllStudents() {
        log.debug("전체 학생 조회");
        return mapper.findAll();
    }

    // 2. 단건 조회
    public Student getStudent(Long id) {
        log.debug("학생 조회 - ID: {}", id);
        Student student = mapper.findById(id);
        if (student == null) {
            throw new IllegalArgumentException("존재하지 않는 학생입니다. ID: " + id);
        }
        return student;
    }

    // 3. 등록
    @Transactional
    public void createStudent(Student student) {
        log.info("학생 등록 시작 - Name: {}", student.getName());

        // 필수 필드 검증
        validateRequiredFields(student);

        // 데이터 형식 검증
        validateDataFormat(student);

        // 이메일 중복 체크 (XML에 findByEmail 필요)
        // Student existing = mapper.findByEmail(student.getEmail());
        // if (existing != null) {
        //     throw new IllegalStateException("이미 사용 중인 이메일입니다.");
        // }

        // 데이터 가공
        student.setName(student.getName().trim());
        student.setEmail(student.getEmail().toLowerCase().trim());

        // 저장
        mapper.create(student);
        log.info("학생 등록 완료 - ID: {}, Name: {}", student.getId(), student.getName());
    }

    // 4. 수정
    @Transactional
    public void updateStudent(Student student) {
        log.info("학생 수정 시작 - ID: {}", student.getId());

        // 존재 여부 확인
        Student existing = mapper.findById(student.getId());
        if (existing == null) {
            throw new IllegalArgumentException("존재하지 않는 학생입니다. ID: " + student.getId());
        }

        // 필수 필드 검증
        validateRequiredFields(student);

        // 데이터 형식 검증
        validateDataFormat(student);

        // 수정
        mapper.update(student);
        log.info("학생 수정 완료 - ID: {}", student.getId());
    }

    // 5. 삭제
    @Transactional
    public void deleteStudent(Long id) {
        log.info("학생 삭제 시작 - ID: {}", id);

        // 존재 여부 확인
        Student student = mapper.findById(id);
        if (student == null) {
            throw new IllegalArgumentException("존재하지 않는 학생입니다. ID: " + id);
        }

        // 삭제
        mapper.delete(id);
        log.info("학생 삭제 완료 - ID: {}", id);
    }

    // === 검증 메서드들 ===

    private void validateRequiredFields(Student student) {
        if (student.getName() == null || student.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 필수입니다.");
        }

        if (student.getEmail() == null || student.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("이메일은 필수입니다.");
        }

        if (student.getAge() == null) {
            throw new IllegalArgumentException("나이는 필수입니다.");
        }
    }

    private void validateDataFormat(Student student) {
        // 이메일 형식 검증
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (!student.getEmail().matches(emailRegex)) {
            throw new IllegalArgumentException("올바른 이메일 형식이 아닙니다.");
        }

        // 이메일 길이 검증
        if (student.getEmail().length() > 150) {
            throw new IllegalArgumentException("이메일은 150자를 초과할 수 없습니다.");
        }

        // 이름 길이 검증
        if (student.getName().length() < 2) {
            throw new IllegalArgumentException("이름은 2자 이상이어야 합니다.");
        }
        if (student.getName().length() > 50) {
            throw new IllegalArgumentException("이름은 50자를 초과할 수 없습니다.");
        }

        // 나이 범위 검증
        if (student.getAge() < 1 || student.getAge() > 150) {
            throw new IllegalArgumentException("나이는 1~150 사이여야 합니다.");
        }

    }
}
