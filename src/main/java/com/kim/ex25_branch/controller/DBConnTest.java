package com.kim.ex25_branch.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class DBConnTest {
//    통신선 테스트 하는 코드


    @Autowired
//    생성자 를 자동으로 주입해주는 어노테이션 -> 다만 생성자를 주입해주는게 권장이됨
    private DataSource dataSource;
//    datasource=전화교환기(DB연결하는 장치)

    @GetMapping("/dbconn")
//    엔드 포인트 dbconn에서는 지금 전화연결이 잘되었나?를 확인하는테스트임
    public String dbConn(){
//getconnection 전화를 걸어봄
//        성공-> 상대방 DB에서 여보세요 라고 응답함+url알려줌
//        실패 -> 신호 없음 + 콘솔에 이유를 출력한다.
        try (Connection connection = dataSource.getConnection()){
            String result = connection.getMetaData().getURL();
            return "DB연결성공"+ result;


        }catch (Exception e){
            e.printStackTrace();
            return "DB연결실패";
        }
    }

}
