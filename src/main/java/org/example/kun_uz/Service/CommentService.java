package org.example.kun_uz.Service;

import org.example.kun_uz.Dto.CommentDto;
import org.example.kun_uz.Repository.ArticleRepo;
import org.example.kun_uz.Repository.CommentRepo;
import org.example.kun_uz.Repository.ProfileRepo;
import org.example.kun_uz.model.Article;
import org.example.kun_uz.model.Comment;
import org.example.kun_uz.model.Profile;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ProfileRepo profileRepo;
    @Autowired
    ArticleRepo articleRepo;

    public List<Comment> getAllComment(){
        return commentRepo.findAll();
    }

    public Comment getCommentById(Integer id){
        return commentRepo.getById(id);
    }

    public Result createComment(CommentDto commentDto){
       boolean existsbycontent = commentRepo.existsByContent(commentDto.getContent());
       if (existsbycontent){
           return new Result(true, "not found");
       }
       Comment comment = new Comment();
       comment.setContent(commentDto.getContent());
        Optional<Profile> profileOptional=profileRepo.findById(commentDto.getProfile_id());
        Profile profile=profileOptional.get();
        comment.setProfile_id((List<Profile>) profile);

        Optional<Article> articleOptional=articleRepo.findById(commentDto.getArticle_id());
        Article article=articleOptional.get();
        comment.setArticle_id((List<Article>) article);
        commentRepo.save(comment);
        return new Result(true, "created");
    }

    public Result updateComment(Integer id , CommentDto commentDto){
        Optional<Comment> commentOptional=commentRepo.findById(id);
        if (commentOptional.isPresent()){
            Comment comment=commentOptional.get();
            comment.setContent(commentDto.getContent());
            Optional<Profile> profileOptional=profileRepo.findById(commentDto.getProfile_id());
            Profile profile=profileOptional.get();
            comment.setProfile_id((List<Profile>) profile);
            Optional<Article> articleOptional=articleRepo.findById(commentDto.getArticle_id());
            Article article=articleOptional.get();
            comment.setArticle_id((List<Article>) article);
            commentRepo.save(comment);
            return new Result(true, "updated");
        }
        return new Result(false, "not found");
    }

    public Result deleteComment(Integer id){
        commentRepo.getById(id);
        return  new Result(true, "deleted");
    }
}
