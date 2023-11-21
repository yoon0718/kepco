package com.example.board.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dao.BoardDao;

import jakarta.servlet.http.HttpServletRequest;


@RestController
public class DBController {
    @Autowired
    BoardDao boardDao;

    @GetMapping("board/list")
    public String boardList(){
        List<Map<String, Object>> qrySet = boardDao.listSelect(); //리스트 받아와서
        String title = null;
        String writer = null;
        
        String seq = null;
        String href = null;
        String delete = null;
        String update = null;
        String num = null;
        String searchCount = null;
        String html = """
            <html>
                <body>
                    <table border='1'>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>삭제</th>
                        <th>수정</th>
                        <th>조회수</th>
            """;
        
        for(int i = 0; i < qrySet.size(); i++){ //for문으로 각각 뽑은 배열을 html에 저장
            num = Integer.toString(i+1);
            seq = qrySet.get(i).get("seq").toString();
            title = qrySet.get(i).get("title").toString();
            writer = qrySet.get(i).get("writer").toString();
            href = String.format("<a href='/board/detail?seq=%s'>",seq);
            delete = String.format("<a href='/board/delete?seq=%s'> 삭제", seq);
            update = String.format("<a href='/board/update?seq=%s'> 수정", seq);
            searchCount = qrySet.get(i).get("search_count").toString();
            html += "<tr>";
            html += "<td>" + num + "번</td>";
            html += "<td>" + href + title + "</a></td>";
            html += "<td>" + writer + "</td>";
            html += "<td>" + delete + "</a></td>";
            html += "<td>" + update + "</a></td>";
            html += "<td>" + searchCount + "</td>";
            html += "</tr>";
        }

        String form = """
                <a href="/"><button type="submit">글쓰기</button></a>
                """;

        html = html + form + "</html>";
        
        return html;
    }


    @GetMapping("board/list1")
    public String boardList1(){
        String result = boardDao.listSelect().toString(); //리스트로 받아온걸 string으로 변환
        String html = "<h1>" + result + "</h1>";
        return html;
    }
    

    @GetMapping("board/insert")
    public String boardInsert(
        @RequestParam("title") String title,
        @RequestParam("content") String content,
        @RequestParam("writer") String writer
    ){
        boardDao.insert(title, content, writer);
        String html = "<html><body>";
        html += writer + "님의 글이 잘 저장 되었습니다.<br>";
        html += "<a href='/board/list'><button>목록</button></a></body><html>";
        return html;
        
    }

    @GetMapping("board/answer")
    public String boardAnswer(
        @RequestParam("seq") String seq
    ){
        String html = "<form action='/board/answer/execute' method='get'>";
        html += String.format("<input type='hidden' name='seq' value=%s>", seq);
        html += String.format("<textarea name='answer'></textarea>");
        String form = """
                <a href="/board/answer/execute"><button type="submit">댓글달기</button></a>
                """;
        html += form;
        
        return html;
    }

    @GetMapping("board/answer/execute")
    public String boardAnswerInsert(
        @RequestParam("seq") String seq,
        @RequestParam("answer") String answer
    ){
        boardDao.insertAnswer(seq, answer);
        return "답글이 등록되었습니다.";
    }


    @GetMapping("board/detail")
    public String boardDetail(
        HttpServletRequest request
    ){
        String seq = request.getParameter("seq");
        String qrySet = boardDao.detailSelect(seq).get(0).get("content").toString();
        String searchCount = boardDao.detailSelect(seq).get(0).get("search_count").toString();
        String html = "<h1 style=\"border: solid 1px black;\">" + qrySet + "</h1>";
        searchCount = Integer.toString(Integer.parseInt(searchCount) + 1);
        boardDao.updateSearchCount(seq, searchCount);
        int count = boardDao.getCountAnswer(seq).size();
        List<Map<String, Object>> answerQrySet =  boardDao.getCountAnswer(seq);
        
        if(count > 0){
            for(int i = 0 ; i < count ; i++){
                html += "<li>" + answerQrySet.get(i).get("answer").toString() + "</li>";
            }
        }
        else {
            html += "<br>달린 답글이 없습니다.<br>";
        }
        html += "<a href='/board/list'><button>목록</button></a>";
        html += String.format("<a href='/board/answer?seq=%s'><button>댓글달기</button></a>", seq);
        return html;
    }

    @GetMapping("board/delete")
    public String boardDelete(
        @RequestParam("seq") String seq
    ){
        String title = boardDao.detailSelect(seq).get(0).get("title").toString();
        boardDao.delete(seq);
        String html = "<html><body>";
        html += title + "글이 삭제되었습니다.<br>";
        html += "<a href='/board/list'><button>목록</button></a></body><html>";
        return html;
    }

    @GetMapping("board/update")
    public String boardUpdate(String seq){
        String title = boardDao.detailSelect(seq).get(0).get("title").toString();
        String content = boardDao.detailSelect(seq).get(0).get("content").toString();
        String html = "<form action='/board/update/execute' method='get'>";
        html += String.format("<input type='hidden' name='seq' value=%s>", seq);
        html += String.format("제목 : <input type='text' name='title' value=%s>", title);
        html += String.format("내용 : <textarea name='content'>%s</textarea>", content);
        String form = """
                <button type="submit">수정하기</button>
                """;
        html += form;
        
        return html;
    }
    @GetMapping("board/update/execute")
    public String boardUpdateExecute(
        @RequestParam("seq") String seq,
        @RequestParam("title") String title,
        @RequestParam("content") String content
    ){
        
        boardDao.update(seq, title, content);
        String html = "<html><body>";
        html += title + "글이 수정되었습니다.<br>";
        html += "<a href='/board/list'><button>목록</button></a></body><html>";
        return html;
        
    }
}
