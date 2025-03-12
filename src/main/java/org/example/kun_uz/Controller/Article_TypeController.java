package org.example.kun_uz.Controller;

import org.example.kun_uz.Dto.Article_typeDto;
import org.example.kun_uz.Service.Article_typeService;
import org.example.kun_uz.model.Article_type;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articletype")
public class Article_TypeController {

    @Autowired
    Article_typeService article_typeService;

    @GetMapping
    public List<Article_type> getArticle_type() {
        return article_typeService.findAll();
    }
    @GetMapping("/{id}")
    public Article_type getArticle_typeById(@PathVariable Integer id) {
        return article_typeService.findById(id);
    }
    @PostMapping
    public Result addArticle_type(@RequestBody Article_typeDto article_typeDto) {
        Result result =article_typeService.save(article_typeDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result updateArticle_type(@PathVariable Integer id , @RequestBody Article_typeDto article_typeDto) {
        Result result = article_typeService.update(id, article_typeDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteArticle_type(@PathVariable Integer id) {
        Result result =article_typeService.delete(id);
        return result;
    }
}
