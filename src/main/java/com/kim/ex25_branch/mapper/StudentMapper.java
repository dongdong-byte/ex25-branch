package com.kim.ex25_branch.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kim.ex25_branch.domain.*;
@Mapper
public interface StudentMapper {
//    Create Read(findAll,findById) Update Delete
    List<Student> findAll();
    Student findById(Long id);
    void create(Student student);
    void update(Student student);
    void delete(Long id);
}
