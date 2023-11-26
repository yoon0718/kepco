package com.example.blog.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.blog.dto.fromForm;
import com.example.blog.entitiy.form;
import com.example.blog.repository.formRepository;
import com.fasterxml.jackson.annotation.JsonProperty;


@Controller
public class pageRequest {
    @Autowired
    private formRepository formrepository;

    @GetMapping("/")
    public String home(Model model){
        List<form> forms = formrepository.findAll();
        model.addAttribute("form", forms);
        return "html/index";
    }

    @GetMapping("/contentPlus")
    public String contentPlus(Model model){
        model.addAttribute("form", new form());
        return "html/contentPlus";
    }

    @PostMapping("/contentPlus")
    public String formSubmit(@ModelAttribute form form, Model model){
        
        formrepository.save(form);
        return "redirect:/";
    }
    
    // @GetMapping("/contentPlus/create")
    // // @JsonProperty("comment")
    // public String contentPlusCreate(
    //     @RequestParam("nickname") String nickname,
    //     @RequestParam("content") String content){
        
    //     form form1 = new form();
    //     // form form1 = form.toEntity();
    //     // form saved = formrepository.save(form1);
    //     form1.setNickname(nickname);
    //     form1.setContent(content);

    //     formrepository.save(form1);
    //     return "html/contentPlus";

    //     // return saved.getSeq();
    // }
}
