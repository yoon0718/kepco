package com.example.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.blog.entitiy.Kuser;
import com.example.blog.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class loginController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/alert")
    public String alert(){
        return "html/alert";
    }
    @GetMapping("/commentAlert")
    public String commentAlert(){
        return "html/commentAlert";
    }
    @GetMapping("/createUserSuccess")
    public String createUserSuccess(){
        return "html/createUserSuccess";
    }
    @GetMapping("/loginAlert")
    public String loginAlert(){
        return "html/loginAlert";
    }
    @GetMapping("/duplication")
    public String duplication(){
        return "html/duplication";
    }
    @GetMapping("/remember")
    public String remember(){
        return "html/remember";
    }
    @GetMapping("/remember2")
    public String remember2(){
        return "html/remember2";
    }

    @GetMapping("/login")
    public String login(){
        
        return "html/login";
    }
    @PostMapping("/login")
    public String loginPost(@RequestParam("userid") String userId, @RequestParam("userpassword") String userPassword, HttpSession session){

        Kuser kuser;
        kuser = userRepository.findByUserIdAndUserPassword(userId, userPassword);
        int count = userRepository.findByUserPasswordAndUserId(userPassword, userId).size();
        if(count < 1){
            
            return "html/alert";
        }
        else{
            session.setAttribute("kuser", kuser);
        
            return "redirect:/";
        }
    }

    @GetMapping("/createUser")
    public String createuser(){
        return "html/createuser";
    }

    @PostMapping("/createUser")
    public String createuserPost(@RequestParam("userid") String userid,
                                @RequestParam("userpassword") String userpassword,
                                @RequestParam("username") String username){
        if(userid == "" || userpassword == "" || username == ""){
            return "html/commentAlert";
        }
        else{ 
            int count = userRepository.findByUserId(userid).size();
            if(count < 1){
                Kuser kuser = new Kuser();
                kuser.setUserId(userid);
                kuser.setUserPassword(userpassword);
                kuser.setUserName(username);
                userRepository.save(kuser);
                return "html/createUserSuccess";
            }
            else{
                return "html/duplication";
            }
        }
    }
}
