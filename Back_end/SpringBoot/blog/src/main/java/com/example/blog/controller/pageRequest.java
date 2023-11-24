package com.example.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.blog.dto.fromForm;
import com.example.blog.entitiy.form;
import com.example.blog.repository.formRepository;
import com.fasterxml.jackson.annotation.JsonProperty;


@Controller
public class pageRequest {
    @Autowired
    formRepository formrepository;

    @GetMapping("/")
    public String home(){
        return "html/index";
    }

    @GetMapping("/contentPlus")
    public String contentPlus(){
        return "html/contentPlus";
    }

    @GetMapping("/contentPlus/create")
    @JsonProperty("comment")
    public long contentPlusCreate(
        @RequestParam("nickname") String nickname,
        @RequestParam("content") String content){
        
        form form1 = form.toEntity();
        form saved = formrepository.save(form1);

        return saved.getSeq();
    }
}
