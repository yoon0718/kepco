package com.example.blog.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
@Getter
@Data
@Entity
public class form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;

    private String nickname;
    private String content;
    
    @Builder
    public form(String nickname, String content){
        
        this.nickname = nickname;
        this.content = content;
    }

    public static form toEntity() {
        return null;
    }


    
    

}
