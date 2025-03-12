package org.example.kun_uz.Repository;

import org.example.kun_uz.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
