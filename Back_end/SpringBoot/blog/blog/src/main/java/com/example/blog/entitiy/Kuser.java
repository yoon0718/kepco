package com.example.blog.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Kuser {
    @Id
    String userId;
    String userPassword;
    String userName;
    String Uuid;
}
