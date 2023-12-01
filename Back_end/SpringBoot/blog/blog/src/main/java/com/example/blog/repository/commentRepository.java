package com.example.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blog.entitiy.comment;

@Repository
public interface commentRepository extends JpaRepository<comment, Long> {

  comment findBySeq(Long seq);

  List<comment> deleteBySeq(Long seq);
    
} 
