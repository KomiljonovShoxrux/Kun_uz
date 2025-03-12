package org.example.kun_uz.Repository;

import org.example.kun_uz.model.SavedArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedArticleRepo extends JpaRepository<SavedArticle, Integer> {
}
