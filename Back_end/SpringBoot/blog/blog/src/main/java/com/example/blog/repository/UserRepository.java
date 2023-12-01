package com.example.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blog.entitiy.Kuser;

@Repository
public interface UserRepository extends JpaRepository<Kuser, String>{

    Kuser findByUserIdAndUserPassword(String userId, String userPassword);


    List<Kuser> findByUserPasswordAndUserId(String userPassword, String userId);


    List<Kuser> findByUserId(String userid);

    
} 
