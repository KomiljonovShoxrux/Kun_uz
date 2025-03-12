package org.example.kun_uz.Controller;

import org.example.kun_uz.Dto.CategoryDto;
import org.example.kun_uz.Service.CategoryService;
import org.example.kun_uz.model.Category;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.findAll();
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.findById(id);
    }
    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categorydto) {
        Result result = categoryService.save(categorydto);
        return result;
    }
    @PutMapping("/{id}")
    public Result updateCategory(@PathVariable Integer id , @RequestBody CategoryDto categorydto) {
        Result result = categoryService.update(id, categorydto);
        return result;

    }
    @DeleteMapping("/{id}")
    public Result deleteCategory(@PathVariable Integer id) {
        Result result = categoryService.delete(id);
        return result;
    }
}
