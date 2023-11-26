package com.example.blog.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blog.entitiy.form;



@Repository
public interface formRepository extends JpaRepository<form, Long> {

} 