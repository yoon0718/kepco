package com.example.jpa.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.jpa.model.Demo;

@Controller
public class HtmlController {
    @GetMapping("Thymeleaf/home")
    public String home(Model model){
        List<String> list = new ArrayList<>();
        
        list.add("list1");
        list.add("list2");
        model.addAttribute("list", list);

        Map<String, Object> map = new HashMap<>();
        map.put("key1", "map1");
        map.put("key2", "map2");
        model.addAttribute("map", map);

        Demo demo = new Demo();
        demo.setSeq(8);
        demo.setUser("하핳ㅎ");
        model.addAttribute("demo", demo);
        

        return "html/home";
    }
    
}
