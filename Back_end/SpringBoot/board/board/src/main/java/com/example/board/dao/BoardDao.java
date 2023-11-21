package com.example.board.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
    @Autowired
    JdbcTemplate jt;

    public List<Map<String, Object>> listSelect(){
        String sqlStmt = "select * from board";
        return jt.queryForList(sqlStmt);
    } //저장된 데이터 불러오기

    public void insert(String title, String content, String writer) {
        String sqlStmt = String.format("INSERT INTO BOARD(title, content, writer) values('%s','%s','%s')", title, content, writer);
        jt.execute(sqlStmt);
    } // 데이터 입력받아 저장시키기

    public  List<Map<String, Object>> detailSelect(String seq){
        String sqlStmt = String.format("select * from board where seq = %s", seq);
        return jt.queryForList(sqlStmt);
    } //

    public void delete(String seq){
        String sqlStmt = String.format("delete from board where seq = %s", seq);
        jt.execute(sqlStmt);

    }// 데이터 삭제

    public void update(String seq, String title, String content) {
        String sqlStmt = String.format("update board set title='%s', content='%s' where seq = '%s'", title, content, seq );
        jt.execute(sqlStmt);
    }

    public void updateSearchCount(String seq, String searchCount){
        String sqlStmt = String.format("update board set search_count='%s' where seq = '%s'", searchCount, seq);
        jt.execute(sqlStmt);
    }

    public void insertAnswer(String seq, String answer){
        String sqlStmt = String.format("insert into board_answer(seq, answer) values('%s','%s')", seq, answer);
        jt.execute(sqlStmt);
    }

    public List<Map<String, Object>> getCountAnswer(String seq){
        String sqlStmt = String.format("select answer from board_answer where seq=%s", seq);
        return jt.queryForList(sqlStmt);   }
}
