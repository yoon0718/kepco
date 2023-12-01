package com.example.blog.entitiy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;
import lombok.Getter;
@Getter
@Data
@Entity //데이터베이스를 위한 모델 클래스
public class form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String userId;
    private String content;
    private String originalFileName;
    private String uuid;
    private String userImg;
    
    
    LocalDateTime now = LocalDateTime.now();
    private String writeDate = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
    
    // @Builder
    // public form(String nickname, String content){
        
    //     this.nickname = nickname;
    //     this.content = content;
    // }

    // public static form toEntity() {
    //     return null;
    // }


    
    

}
