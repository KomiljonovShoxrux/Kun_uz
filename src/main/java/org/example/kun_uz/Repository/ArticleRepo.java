package org.example.kun_uz.Repository;

import org.example.kun_uz.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface ArticleRepo extends JpaRepository<Article , UUID> {

    boolean existsByTitle(String title);
}
