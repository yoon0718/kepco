package com.example.blog.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    @GetMapping("/createUserFail")
    public String commentAlert(){
        return "html/createUserFail";
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
                                @RequestParam("username") String username,
                                @RequestParam("file") MultipartFile mFile){
        System.out.println(mFile);
        System.out.println("왕;ㅣ리노");
        String oName = mFile.getOriginalFilename();
        if(userid == "" || userpassword == "" || username == "" || oName == ""){
            return "html/createUserFail";
        }
        else{ 
            int count = userRepository.findByUserId(userid).size();
            if(count < 1){
                Kuser kuser = new Kuser();
                String saveOFolder = "C:/Back_end/blog/blog/src/main/resources/static/contentImages/";
                String uid = UUID.randomUUID().toString();
                File saveFile = new File(saveOFolder + uid);

                kuser.setUserId(userid);
                kuser.setUserPassword(userpassword);
                kuser.setUserName(username);
                kuser.setUuid(uid);
                try {
                    mFile.transferTo(saveFile);
                    userRepository.save(kuser);
                } catch (IllegalStateException | IOException e) {
                    e.printStackTrace();
                }
                return "html/createUserSuccess";
            }
            else{
                return "html/duplication";
            }
        }
    }
    
}
