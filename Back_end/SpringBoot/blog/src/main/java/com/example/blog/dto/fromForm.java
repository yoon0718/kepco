package com.example.blog.dto;

import com.example.blog.entitiy.form;

public class fromForm {
    private String nickname;
    private String content;

    public fromForm(String nickname, String content){
        this.nickname = nickname;
        this.content = content;
    }

    public form toEntity(){
        return new form(nickname, content);
    }
}
