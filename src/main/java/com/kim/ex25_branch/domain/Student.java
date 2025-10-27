package com.kim.ex25_branch.domain;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * 학생 엔티티 (검증 추가)
 *
 * 💡 비유: 회원 가입 폼의 입력 규칙
 * - 이름 필수, 2자 이상
 * - 이메일 필수, 이메일 형식
 * - 나이 필수, 1~150 사이
 *
 * ✅ Bean Validation 애노테이션:
 * @NotNull: null 불가
 * @NotBlank: null, 빈 문자열, 공백만 있는 문자열 불가
 * @Email: 이메일 형식 체크
 * @Min/@Max: 최소/최대 값 체크
 * @Size: 문자열 길이 체크
 */




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
//    학생 ID 자동 생성
private Long id;
//    학생이름
//    예외 처리
//    1.이름은 필수
//    2.2자이상 50자 이하
@NotBlank(message = "이름은 필수 입니다")
@Size(min = 2,max = 50,message = "이름은 2자 이상 50자 이하이여야 합니다.")
private String name;
//    나이 (필수)
//    조건
//    1.1세 이상 150세 이하
//    int-> Integer 변경 -> null체크 가능
@NotNull(message = "나이는 필수 입니다.")
@Min(value = 1 , message = "나이는 1세 이상이어야합니다")
@Max(value = 150 , message = "나이는 150세 이하여야 합니다")

private  Integer age;

//    이메일(필수)
//   조건: 이메일형식을 지켜야함
@NotBlank(message = "이메일은 필수입니다.")
@Email(message = "올바른 이메일 형식이 아닙니다.")
@Size(max=150,message = "이메일은 150자 이하이여야합니다.")
private String email;
//생성일시, 수정일시 -> 자동으로 생성되고 갱신되므로 예외처리할 굳이 필요는 없음

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
