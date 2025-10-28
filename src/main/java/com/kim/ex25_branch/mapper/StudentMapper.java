package com.kim.ex25_branch.mapper;


import java.util.List;

import org.apache.ibatis.annotations.*;

import com.kim.ex25_branch.domain.*;

@Mapper
public interface StudentMapper {
//    Create Read(findAll,findById) Update Delete
<<<<<<< HEAD
//    @Select("SELECT id, name, email, age, created_at, updated_at FROM student")
    List<Student> findAll();
//@Select("SELECT\n" +
//        "        id,\n" +
//        "        name,\n" +
//        "        email,\n" +
//        "        age,\n" +
//        "        created_at , <!-- DB 컬럼명 -->\n" +
//        "        updated_at\n" +
//        "        FROM student\n" +
//        "        WHERE id = #{id}")
    Student findById(Long id);
//@Insert("INSERT INTO student (\n" +
//        "        name,\n" +
//        "        email,\n" +
//        "        age,\n" +
//        "        created_at,\n" +
//        "        updated_at\n" +
//        "        )\n" +
//        "        VALUES (\n" +
//        "        #{name},\n" +
//        "        #{email},\n" +
//        "        #{age},\n" +
//        "        NOW(),\n" +
//        "        NOW()\n" +
//        "        )")
    void create(Student student);
//@Update("UPDATE student\n" +
//        "        SET\n" +
//        "        name = #{name},\n" +
//        "        email = #{email},\n" +
//        "        age = #{age},\n" +
//        "        updated_at = NOW()\n" +
//        "        WHERE id = #{id}")
    void update(Student student);
//@Delete(" DELETE FROM student\n" +
//        "        WHERE id = #{id}")
=======
    List<Student> findAll();
@Select("SELECT\n" +
        "        id,\n" +
        "        name,\n" +
        "        email,\n" +
        "        age,\n" +
        "        created_at , <!-- DB 컬럼명 -->\n" +
        "        updated_at\n" +
        "        FROM student\n" +
        "        WHERE id = #{id}")
    Student findById(Long id);
@Insert("INSERT INTO student (\n" +
        "        name,\n" +
        "        email,\n" +
        "        age,\n" +
        "        created_at,\n" +
        "        updated_at\n" +
        "        )\n" +
        "        VALUES (\n" +
        "        #{name},\n" +
        "        #{email},\n" +
        "        #{age},\n" +
        "        NOW(),\n" +
        "        NOW()\n" +
        "        )")
    void create(Student student);
@Update("UPDATE student\n" +
        "        SET\n" +
        "        name = #{name},\n" +
        "        email = #{email},\n" +
        "        age = #{age},\n" +
        "        updated_at = NOW()\n" +
        "        WHERE id = #{id}")
    void update(Student student);
@Delete(" DELETE FROM student\n" +
        "        WHERE id = #{id}")
>>>>>>> f2/vaild
    void delete(Long id);
}
