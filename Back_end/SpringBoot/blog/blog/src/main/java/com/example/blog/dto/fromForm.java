package com.example.blog.dto;


import org.springframework.web.multipart.MultipartFile;


public class fromForm {
    private String nickname;
    private String content;
    private MultipartFile file;

    public fromForm(String nickname, String content, MultipartFile file){
        this.nickname = nickname;
        this.content = content;
        this.file = file;
    }

    // public form toEntity(){
    //     return new form(nickname, content);
    // }
}
