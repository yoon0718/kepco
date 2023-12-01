package com.example.blog.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blog.entitiy.form;



@Repository
public interface formRepository extends JpaRepository<form, Long> {
    public List<form> findAllByOrderBySeqDesc();

    public form findByOriginalFileName(String oName);

    public form findBySeq(Long seq);


} 