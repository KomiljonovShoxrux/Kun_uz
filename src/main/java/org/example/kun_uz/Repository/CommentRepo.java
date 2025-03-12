package org.example.kun_uz.Repository;

import org.example.kun_uz.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment , Integer> {

    boolean existsByContent(String content);
}
