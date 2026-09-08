package example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.test.model.dto.CommentDto;
import example.test.service.BoardService;
import example.test.service.CommentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController @RequestMapping ("/api/board/comment")
public class commentController {
    @Autowired private CommentService commentService;
    @Autowired  private  BoardService boardService;

    @PostMapping("")
    public boolean 댓글등록(@RequestBody CommentDto commentDto) {
        return commentService.댓글등록(commentDto);
    }

    @DeleteMapping("")
    public  boolean 댓글삭제(@RequestParam(name = "commentid")Integer commentid, @RequestParam(name = "password")String password){
    return commentService.댓글삭제(commentid, password);
    }
}
