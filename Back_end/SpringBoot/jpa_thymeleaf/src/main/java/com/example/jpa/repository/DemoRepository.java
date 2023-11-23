package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.model.Demo;

@Repository
public interface DemoRepository extends JpaRepository<Demo, Long>  {

    //List<Demo> findByUser(String user); //<table, type>
    Demo findByUser(String user);
    List<Demo> findBySeq(long seq);
    
}
