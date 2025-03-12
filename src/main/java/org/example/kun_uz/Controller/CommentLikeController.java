package org.example.kun_uz.Controller;

import org.example.kun_uz.Dto.CommentLikeDto;
import org.example.kun_uz.Service.CommentLikeService;
import org.example.kun_uz.model.CommentLike;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentlike")
public class CommentLikeController {

    @Autowired
    CommentLikeService commentLikeService;

    @GetMapping
    public List<CommentLike> getCommentLikeList(){
        return commentLikeService.getall();
    }
    @GetMapping("/{id}")
    public CommentLike getCommentLikeById(@PathVariable Integer id){
        return commentLikeService.getById(id);
    }
    @PostMapping("/{id}")
    public Result createCommentLike(@RequestBody CommentLikeDto commentLikeDto){
        Result result=commentLikeService.createCommentlike(commentLikeDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result updateCommentLike(@PathVariable Integer id , @RequestBody CommentLikeDto commentLikeDto){
        Result result=commentLikeService.updateCommentlike(id,commentLikeDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteCommentLike(@PathVariable Integer id){
        Result result=commentLikeService.deleteCommentlike(id);
        return result;
    }




}
