package com.kim.ex25_branch.mapper;


import com.kim.ex25_branch.domain.StudentTest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapperTest02 {
    @Select("SELECT * FROM student ORDER BY #{id} DESC")
    List<StudentTest> findAll();



    @Insert("INSERT INTO student(NAME, email, age) \r\n"
            + "  	VALUES (#{name}, #{email}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(StudentTest student);

    @Select("SELECT * FROM student where id=#{id} ")
    StudentTest findById(Long id);
}
