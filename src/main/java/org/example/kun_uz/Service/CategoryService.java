package org.example.kun_uz.Service;

import org.example.kun_uz.Dto.CategoryDto;
import org.example.kun_uz.Repository.CategoryRepo;
import org.example.kun_uz.model.Category;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
    public Category findById(Integer id) {
        return categoryRepo.findById(id).get();
    }

    public Result save(CategoryDto categoryDto) {
        Category category = new Category();
        category.setOrder_number(categoryDto.getOrder_number());
        category.setName_uz(categoryDto.getName_uz());
        category.setName_ru(categoryDto.getName_ru());
        category.setName_eng(categoryDto.getName_eng());
        category.setCrated_date(categoryDto.getCrated_date());

        categoryRepo.save(category);
        return new Result(true, "Category saved");
    }

    public Result update(Integer id , CategoryDto categoryDto) {

        Optional<Category> category = categoryRepo.findById(id);
        if (category.isPresent()) {
            Category category1 = category.get();
            category1.setOrder_number(categoryDto.getOrder_number());
            category1.setName_uz(categoryDto.getName_uz());
            category1.setName_ru(categoryDto.getName_ru());
            category1.setName_eng(categoryDto.getName_eng());
            category1.setCrated_date(categoryDto.getCrated_date());
            categoryRepo.save(category1);
            return new Result(true, "Category updated");

        }
        return new Result(false, "Category not found");
    }

    public Result delete(Integer id) {
         categoryRepo.deleteById(id);
         return new Result(true, "Category deleted");

    }
}
