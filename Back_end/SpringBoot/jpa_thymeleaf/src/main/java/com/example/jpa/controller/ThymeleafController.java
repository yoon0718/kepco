package com.example.jpa.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jpa.model.Demo;
import com.example.jpa.repository.DemoRepository;

@Controller
public class ThymeleafController {
    @Autowired
    DemoRepository demoRepository;
    @GetMapping("/Thymeleaf/user")
    public String user(Model model){
        Map<String, Object> user = null;
        user = new HashMap<>();
        user.put("userId", "z");
        user.put("userName", "zoo");
        user.put("userAge", 25);
        model.addAttribute("user", user);
        return "html/user";

    }

    @GetMapping("/Thymeleaf/userList")
  public String userList(Model model) {
    List<Map<String, Object>> userList = new ArrayList<>();
    Map<String, Object> user = null;
    user = new HashMap<>();
    user.put("userId", "a");
    user.put("userName", "apple");
    user.put("userAge", 21);
    userList.add(user);
    user = new HashMap<>();
    user.put("userId", "b");
    user.put("userName", "banana");
    user.put("userAge", 22);
    userList.add(user);
    user = new HashMap<>();
    user.put("userId", "c");
    user.put("userName", "carrot");
    user.put("userAge", 23);
    userList.add(user);
    model.addAttribute("userList", userList);
    return "html/userList";
  }

  @GetMapping("/Thymeleaf/mode")
  public String mode(Model model){
    Demo mode = demoRepository.findByUser("asdaf");
    model.addAttribute("mode", mode);
    return "html/mode";
  }

  @GetMapping("/Thymeleaf/pagination")
  public String pagination(Model model, @RequestParam(defaultValue = "4") int page){
    int startPage = (page - 1) / 10 * 10 + 1;
    int endPage = startPage + 9;
    model.addAttribute("startPage", startPage);
    model.addAttribute("endPage", endPage);
    model.addAttribute("page", page);
    return "html/pagination";
  }
}
