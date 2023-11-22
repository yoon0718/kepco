package com.example.mybatis.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatis.mapper.BoardMapper;
// import com.example.mybatis.mapper.DemoMapper;
@RestController
public class DBController {
    // @Autowired
    // DemoMapper demoMapper;
    @Autowired
    BoardMapper boardMapper;
    

    // @GetMapping("/mybatis/demo")
    // public List<Map<String, Object>> mybatisDemo(){
    //     return demoMapper.select();
    // }

    // @GetMapping("/mybatis/demoId")
    // public List<Map<String, Object>> mybatisById(){
    //     return demoMapper.selectById("1");
    // }

    // @GetMapping("/mybatis/demoInsert")
    // public String mybatisInsert(){
    //     demoMapper.insert("6", "FFF");
    //     return "잘 저장되었습니다.";
    // }

    // @GetMapping("/mybatis/demoUpdate")
    // public String mybatisUpdate(){
    //     demoMapper.update("6", "abc");
    //     return "잘 수정되었습니다.";
    // }

    // @GetMapping("/mybatis/demoDelete")
    // public String mybatisDelete(){
    //     demoMapper.delete("4");
    //     return "잘 삭제되었습니다.";
    // }
    
    @GetMapping("/mybatis/boardList")
    public List<Map<String, Object>> boardList(){
        return boardMapper.selectList();
    }
    @GetMapping("/mybatis/detail")
    public List<Map<String, Object>> boardDetail(){
        return boardMapper.selectDetail("1");
    }

    @GetMapping("/mybatis/insert")
    public String boardInsert(){
        LocalDateTime now = LocalDateTime.now();
        

        String title = "두둠칫칫칫칫";
        String content = "두둠두둠칫칫";
        String writer = "윤여록";
        String writeDate = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
        boardMapper.insert(title, content, writer, writeDate);
        return "저장되었습니다.";
    }

    @GetMapping("/mybatis/update")
    public String boardUpdate(){
        LocalDateTime now = LocalDateTime.now();
        String seq = "1";
        String title = "두둠칫칫칫칫";
        String content = "두둠두둠칫칫";
        String writeDate = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
        boardMapper.update(seq, title, content);
        return writeDate + "에 수정되었습니다.";
    }



}
