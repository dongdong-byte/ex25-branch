package com.kim.ex25_branch.controller;


import com.kim.ex25_branch.domain.Student;
import com.kim.ex25_branch.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/student/valid")
@RequiredArgsConstructor
public class StudentControllerValidation {

private  final StudentService studentService;
//1.list화면: 전체 학생 목록
    @GetMapping
//    model에 객체를 담으면 해당 데이터를 뷰에서 ${students}와 같은 형태로 사용할수 있습니다.
    public  String list(Model model){
//        모든 학생 데이터를 DB에서 가져오는 서비스 호출
//        가져온 학생목록 List<Student> 을 students 이란 모델에 담는다.
//        xml에서 students로 사용된다
        model.addAttribute("students",studentService.getAllStudents());
return  "student/list_validtest";
    }
//2. 등록폼 :form화면 : 새로운 학생 정보를 입력하기 위한 빈화면
    @GetMapping("/new")
    public  String createForm(Model model){
        model.addAttribute("student",new Student());
        return  "student/form_validtest";
    }
//등록폼 validTest:form화면 : 새로운 학생 정보를 입력하기 위한 빈화면
    @GetMapping("/new/valid")
    public  String createFormValidation(Model model){

        model.addAttribute("student",new Student());
        return  "student/form_validtest";
    }
//등록처리 :학생 정보를 기록후 저장버튼을 클릭하면 학생정보를 insert
    @PostMapping
    public  String create(@Valid @ModelAttribute Student student, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
// 결과에 에러가 잇으면 , 입력 안하고 ,입력 창으로 돌아가기
            return  "student/form_validtest";

        }
//        이미 학생 저장이 완료가 되었음
        studentService.createStudent(student);
        return  "redirect:/student/valid";
    }
//    수정처리
    @PostMapping("/{id}")
    public String update(@PathVariable Long id , @Valid @ModelAttribute Student student , BindingResult bindingResult){

        if(bindingResult.hasErrors()){
// 결과에 에러가 잇으면 , 입력 안하고 ,입력 창으로 돌아가기
            return  "student/form_validtest";

        }
//        이미 학생 저장이 완료가 되었음
        student.setId(id);
        studentService.updateStudent(student);
        return  "redirect:/students/valid";
    }
//    수정폼
    @GetMapping("/{id}/edit")
    public  String updateForm(@PathVariable Long id ,Model model){
        model.addAttribute("student",studentService.getStudent(id));
        return  "student/form_validtest";
    }
//삭제 처리
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable long id){
        studentService.deleteStudent(id);
        return  "redirect:/students/valid";

    }
}
