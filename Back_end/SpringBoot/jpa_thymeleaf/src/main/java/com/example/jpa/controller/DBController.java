package com.example.jpa.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.model.Demo;
import com.example.jpa.repository.DemoRepository;

@RestController
public class DBController {
    @Autowired
    DemoRepository demoRepository;

    @GetMapping("/jpa/demo")
    public List<Demo> jpaDemo(){
        return demoRepository.findAll();
    }

    // @GetMapping("/jpa/user")
    // public List<Demo> jpaSelect1(){
    //     return demoRepository.findByUser("AAA");
    // }

    @GetMapping("/jpa/user1")
    public String jpaSelect2(){
        String user = demoRepository.findByUser("AAA").getUser();
        return user;
    }

    @GetMapping("/jpa/save") // 있으면 update 없으면 insert
    public String jpaInsert(){
        Demo data = new Demo();
        data.setSeq(7);
        data.setUser("윤여록");
        demoRepository.save(data);
        return data.getUser()+"님이 저장되었습니다.";
    }

    @GetMapping("/jpa/delete")
    public String jpaDelete(){
        Demo data = new Demo();
        data.setSeq(7);
        demoRepository.delete(data);
        return data.getSeq()+"번째가 삭제되었습니다";
    }



   
}
