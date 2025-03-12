package org.example.kun_uz.Controller;

import org.example.kun_uz.Dto.SavedArticleDto;
import org.example.kun_uz.Service.SavedArticleService;
import org.example.kun_uz.model.Result;
import org.example.kun_uz.model.SavedArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/savedarticle")
public class SavedArticleController {

    @Autowired
    SavedArticleService savedArticleService;
    @GetMapping
    public List<SavedArticle> savedArticles(){
        return savedArticleService.getallsavedarticles();
    }
    @GetMapping("/{id}")
    public SavedArticle savedArticle(@PathVariable Integer id){
        return savedArticleService.getsavedarticlebyid(id);
    }
    @PostMapping
    public Result saveSavedArticle(@RequestBody SavedArticleDto savedArticleDto){
        Result result= savedArticleService.createSavedArticle(savedArticleDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result updateSavedArticle(@PathVariable Integer id , @RequestBody SavedArticleDto savedArticleDto){
        Result result= savedArticleService.updateSavedArticle(id,savedArticleDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteSavedArticle(@PathVariable Integer id){
        Result result= savedArticleService.deleteSavedArticle(id);
        return result;
    }
}
