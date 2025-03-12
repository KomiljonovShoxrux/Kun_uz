package org.example.kun_uz.Controller;

import org.example.kun_uz.Dto.CommentDto;
import org.example.kun_uz.Service.CommentService;
import org.example.kun_uz.model.Comment;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;


    @GetMapping
    public List<Comment> getallcomment(){
        return commentService.getAllComment();
    }
    @GetMapping("/{id}")
    public Comment getbyId(Integer id){
        return commentService.getCommentById(id);
    }
    @PostMapping
    public Result addComment(@RequestBody CommentDto commentDto){
        Result result = commentService.createComment(commentDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result updateComment(@PathVariable Integer id, @RequestBody CommentDto commentDto){
        Result result = commentService.updateComment(id, commentDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteComment(@PathVariable Integer id){
        Result result = commentService.deleteComment(id);
        return result;
    }
}
