package com.kim.ex25_branch.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class DBConnTest {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/dbconn")
    public String dbconn(){
        try (Connection connection = dataSource.getConnection()){
            String result = connection.getMetaData().getURL();
            return "DB연결 성공 : " + result;
        }catch (Exception e){
            e.printStackTrace();
            return "DB연결 실패";
        }

    }

}
