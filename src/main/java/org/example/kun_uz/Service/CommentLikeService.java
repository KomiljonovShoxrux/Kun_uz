package org.example.kun_uz.Service;

import org.example.kun_uz.Dto.CommentLikeDto;
import org.example.kun_uz.Repository.CommentLikeRepo;
import org.example.kun_uz.Repository.CommentRepo;
import org.example.kun_uz.Repository.ProfileRepo;
import org.example.kun_uz.model.Comment;
import org.example.kun_uz.model.CommentLike;
import org.example.kun_uz.model.Profile;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentLikeService {

    @Autowired
    CommentLikeRepo commentLikeRepo;

    @Autowired
    ProfileRepo profileRepo;
    @Autowired
    CommentRepo commentRepo;

    public List<CommentLike> getall(){
        return commentLikeRepo.findAll();
    }

    public CommentLike getById(Integer id){
        return commentLikeRepo.getById(id);
    }

    public Result createCommentlike(CommentLikeDto commentLikeDto){
        CommentLike commentLike = new CommentLike();
        commentLike.setStatus(commentLikeDto.getStatus());

        Optional<Profile> profileOptional=profileRepo.findById(commentLikeDto.getProfile_id());
        Profile profile=profileOptional.get();

        Optional<Comment> commentOptional=commentRepo.findById(commentLikeDto.getComment_id());
        Comment comment=commentOptional.get();

        commentLike.setProfile_id(profile);
        commentLike.setComment_id((List<Comment>) comment);
        commentLikeRepo.save(commentLike);
        return new Result(true, "Comment Created");
    }

    public Result updateCommentlike(Integer id , CommentLikeDto commentLikeDto){
        Optional<CommentLike> commentLikeOptional=commentLikeRepo.findById(id);
        if (commentLikeOptional.isPresent()){

           CommentLike commentLike=commentLikeOptional.get();
            commentLike.setStatus(commentLikeDto.getStatus());

            Optional<Profile> profileOptional=profileRepo.findById(commentLikeDto.getProfile_id());
            Profile profile=profileOptional.get();

            Optional<Comment> commentOptional=commentRepo.findById(commentLikeDto.getComment_id());
            Comment comment=commentOptional.get();

            commentLike.setProfile_id(profile);
            commentLike.setComment_id((List<Comment>) comment);
            commentLikeRepo.save(commentLike);
            return new Result(true, "Comment Updated");

        }
        return new Result(false, "Comment Not Found");
    }

    public Result deleteCommentlike(Integer id){
        commentLikeRepo.deleteById(id);
        return new Result(true, "Comment Deleted");
    }
}
