package com.kim.ex25_branch.controller;


import com.kim.ex25_branch.domain.*;
import com.kim.ex25_branch.service.*;
import com.kim.ex25_branch.mapper.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 학생 관리 컨트롤러
 *
 * 💡 비유: 식당의 카운터 직원
 * - 손님(사용자)의 주문을 받고
 * - 주방(Service)에 전달하고
 * - 결과를 손님에게 알려줌
 *
 * 개선 사항:
 * 1. 검증 추가 (@Valid)
 * 2. 예외 처리 추가
 * 3. 사용자 피드백 메시지 추가
 * 4. 로깅 추가
 */

@Slf4j
@Controller("day1026StudentController")
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
//    list 전체 학생 목록 조회 READ
//    @param model 뷰에 전달할 데이터
//    @return 목록 페이지
//
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
// 상수로 정의하면 오타 방지!
//private static final String REDIRECT_STUDENT = "redirect:/student";
=======
>>>>>>> f2/vaild
=======
>>>>>>> f2/vaild
=======
// 상수로 정의하면 오타 방지!
//private static final String REDIRECT_STUDENT = "redirect:/student";
>>>>>>> f2/dbconn
    @GetMapping
    public String list(Model model) {
        log.info("학생 목록 조회 요청");
//        개선사팡 : 속성명은 복수형으로 바꿀걸 요청-> 리스트 이므르
        model.addAttribute("students",studentService.getAllStudents());
        return"student/list";

    }
//    새 학생 등록 폼 CREATE
//    @param model 뷰에 전달할 데이터
//    @return 목록 페이지


    @GetMapping("/new")
    public String createForm(Model model){
        log.info("학생 등록 폼 요청");

        model.addAttribute("student", new Student());
        return "student/form";

    }
//    학생 수정폼 UPDATE
//    @param id 수정할 학생 ID
//    @param model 뷰에 전달할 데이터
//    @param redirectAttribues 리 다이렉트 시 메시지 전달
//    @return 수정 폼 페이지 또는 목록 페이지

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id,
                           Model model
            , RedirectAttributes redirectAttributes){
        log.info("학생 수정 폼 요청 -ID{}", id);
        try{
            Student student = studentService.getStudent(id);
//            개선 : null 체크를 명확히 하기
            if(student == null){
                log.warn("학생을 찾을수 없음 -ID{}", id);
                redirectAttributes.addFlashAttribute(
                        "error",
                        "ID" + id + "번 학생을 찾을수가 없습니다."
                );
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                return "redirect:/student";
=======
                return "redirect:/studentfinal";
>>>>>>> f2/vaild
=======
                return "redirect:/studentfinal";
>>>>>>> f2/vaild
=======
                return "redirect:/student";
>>>>>>> f2/dbconn
            }
            model.addAttribute("student",student);
            return"student/form";

        }catch(Exception e){
            log.error("학생 조회중 오류 발생 -ID {}" ,id);
            redirectAttributes.addFlashAttribute("error",
                    "학생 정보를 불러오는데 오류가 발생했습니다");
            return "redirect:/student";

        }

    }
//    폼 제출 처리(등록/수정) UPDATE+CREATE
//    개선 : 검증 추가(@Valid)

//    @Param student 저장할 학생 정보
//    @Param bindingResult 검증 결과
//    @Param RedirectAttributes 리다이렉트시 메세지 전달-> 사용자에게 피드백을 전달
//   @return  list 페이지 또는 form 페이지(오류시)
@PostMapping
public String save(@ModelAttribute Student student,
                   BindingResult bindingResult,
                   RedirectAttributes redirectAttributes){
//        검증 오류가 있으면 form으로 돌아가기
    if(bindingResult.hasErrors()){
        log.warn("학생 정보 검증 실패 : {}", bindingResult.getAllErrors());
        return  "student/form";
    }
    try{
        if(student.getId() == null){
//            등록
            log.info("새 학생 등록 요청 {}" , student.getName());
            studentService.createStudent(student);
//
            redirectAttributes.addFlashAttribute("success",
                    student.getName()+ "님이 등록되었습니다.");

        }else {
//            수정
            log.info("새 학생 수정 요청 ID {} , 이름 : {}",
                    student.getId(),student.getName());
            studentService.updateStudent(student);
            redirectAttributes.addFlashAttribute("success",
                    student.getName() + "님의 정보가 수정되었습니다.");

        }
        return "redirect:/student";

    }catch(Exception e){
        log.error("학생 저장 중 오류가 발생 했습니다",e);
        redirectAttributes.addFlashAttribute("error",
                "저장중 오류가 발생했습니다 : " + e.getMessage());
        return "redirect:/student";

    }

}
//    삭제 DELETE
//    @Param  id 삭제할 학생 ID
//    @Param redirectAttributes 리다이렉트시 메세지 전달
//    @return 목록 페이지

@PostMapping("/{id}/delete")
public String delete(@PathVariable Long id,
                     RedirectAttributes redirectAttributes){
    log.info("학생 삭제 요청 - ID :{}",id);
    try {
//    개선 사항 = 삭제 전 학생 존재 확인
        Student student = studentService.getStudent(id);
        if( student == null){
            log.warn("삭제할 학생을 찾을수 없음 - ID : {}",id);
            redirectAttributes.addFlashAttribute("error",
                    "삭제할 학생을 찾을수가 없습니다.");
            return "redirect:/student";

        }
        String studentName = student .getName();
        studentService.deleteStudent(id);
        log.info("새 학생 삭제 완료 - ID {} , 이름 : {}",id,studentName);
        redirectAttributes.addFlashAttribute("sucess",
                studentName+"님이 삭제 되었습니다");



}catch(Exception e){
        log.error("학생 삭제 중 오류가 발생하였습니다 - ID {}" ,id, e);
        redirectAttributes.addFlashAttribute("error",
                "삭제중 오류가 발생했습니다.");


}
    return "redirect:/student";

}

//전체 예외 처리

//    개선 : 예외 발생시 사용자 친화적 메세지

    @ExceptionHandler(Exception.class)
    public  String handleException(
            Exception e,
            RedirectAttributes redirectAttributes
    ){
        log.error("예상치 못한 오류가 발생했습니다.",e);
        redirectAttributes.addFlashAttribute("error",
                "오류가 발생했습니다. 잠시후 다시 시도해주세용");
        return "redirect:/student";

    }


}

