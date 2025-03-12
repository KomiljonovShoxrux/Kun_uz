package org.example.kun_uz.Controller;

import org.example.kun_uz.Dto.ArticleDto;
import org.example.kun_uz.Service.ArticleService;
import org.example.kun_uz.model.Article;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping
    public List<Article> getArticles(){
        return articleService.getall();
    }
    @GetMapping("/{id}")
    public Article getArticle(@PathVariable UUID id){
        return articleService.getarticlebyId(id);
    }
    @PostMapping
    public Result createArticle(@RequestBody ArticleDto articleDto){
        Result result = articleService.createarticle(articleDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result updateArticle(@PathVariable UUID id , @RequestBody ArticleDto articleDto){
        Result result= articleService.updatearticle(id , articleDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteArticle(@PathVariable UUID id){
        Result result= articleService.deletearticle(id);
        return result;
    }
}
