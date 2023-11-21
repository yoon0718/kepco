package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // request에 대한 요청을 처리
public class PageRequest {
    @GetMapping("/")
    public String home(){
        return "html/index";
    }

    
}
