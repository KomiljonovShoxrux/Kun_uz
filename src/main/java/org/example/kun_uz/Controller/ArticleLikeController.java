package org.example.kun_uz.Controller;

import org.example.kun_uz.Dto.ArticleLikeDto;
import org.example.kun_uz.Service.ArticleLikeService;
import org.example.kun_uz.model.ArticleLike;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articlelike")
public class ArticleLikeController {

    @Autowired
    ArticleLikeService articleLikeService;


    @GetMapping
    public List<ArticleLike> getArticleLike() {
        return articleLikeService.getAllArticleLikes();
    }
    @GetMapping("/{id}")
    public ArticleLike getArticleLike(@PathVariable Integer id) {
        return articleLikeService.getArticleLike(id);
    }

    @PostMapping
    public Result addArticleLike(@RequestBody ArticleLikeDto articleLikeDto) {
        Result result = articleLikeService.createArticleLike(articleLikeDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result updateArticleLike(@PathVariable Integer id, @RequestBody ArticleLikeDto articleLikeDto) {
        Result result = articleLikeService.updateArticleLike(id, articleLikeDto);
        return result;
    }

    @DeleteMapping
    public Result deleteArticleLike(@PathVariable Integer id) {
        Result result = articleLikeService.deleteArticleLike(id);
        return result;
    }
}
