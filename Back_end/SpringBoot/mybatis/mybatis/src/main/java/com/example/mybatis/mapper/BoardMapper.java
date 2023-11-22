package com.example.mybatis.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

    public List<Map<String, Object>> selectList();
    public List<Map<String, Object>> selectDetail(String seq);
    public void insert(String title, String content, String writer, String writeDate);
    public void update(String seq, String title, String content);
    
}
