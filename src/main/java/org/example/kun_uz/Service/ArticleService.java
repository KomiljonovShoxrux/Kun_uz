package org.example.kun_uz.Service;

import org.example.kun_uz.Dto.ArticleDto;
import org.example.kun_uz.Repository.ArticleRepo;
import org.example.kun_uz.Repository.CategoryRepo;
import org.example.kun_uz.Repository.RegionRepo;
import org.example.kun_uz.model.Article;
import org.example.kun_uz.model.Category;
import org.example.kun_uz.model.Region;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArticleService {

    @Autowired
    ArticleRepo articleRepo;

    @Autowired
    RegionRepo regionRepo;

    @Autowired
    CategoryRepo categoryRepo;


    public List<Article> getall() {
        return articleRepo.findAll();
    }

    public Article getarticlebyId(UUID id) {
        return articleRepo.findById(id).get();
    }

    public Result createarticle(ArticleDto articleDto) {
        boolean existsbytitle = articleRepo.existsByTitle(articleDto.getTitle());
        if (existsbytitle) {
            return new Result(false, "Title already exists");
        }
        Article article = new Article();
        article.setTitle(articleDto.getTitle());
        article.setDescription(articleDto.getDescription());
        article.setContent(articleDto.getContent());
        article.setShared_count(articleDto.getShared_count());
        article.setImage_id(articleDto.getImage_id());


        Optional<Region> regionOptional = regionRepo.findById(articleDto.getRegion_id());
        Region region = regionOptional.get();
        article.setRegion_id((List<Region>) region);

        Optional<Category> categoryOptional = categoryRepo.findById(articleDto.getCategory_id());
        Category category = categoryOptional.get();
        article.setCategory_id((List<Category>) category);

        articleRepo.save(article);
        return new Result(true, "Article created");
    }

    public Result updatearticle(UUID id, ArticleDto articleDto) {
        Optional<Article> articleOptional = articleRepo.findById(id);
        if (articleOptional.isPresent()) {
            Article article = articleOptional.get();
            article.setTitle(articleDto.getTitle());
            article.setDescription(articleDto.getDescription());
            article.setContent(articleDto.getContent());
            article.setShared_count(articleDto.getShared_count());
            article.setImage_id(articleDto.getImage_id());

            Optional<Region> regionOptional = regionRepo.findById(articleDto.getRegion_id());
            Region region = regionOptional.get();
            article.setRegion_id((List<Region>) region);

            Optional<Category> categoryOptional = categoryRepo.findById(articleDto.getCategory_id());
            Category category = categoryOptional.get();
            article.setCategory_id((List<Category>) category);
            articleRepo.save(article);

            return new Result(true, "Article Created");

        }
        return new Result(false, "Article not found");
    }

    public Result deletearticle(UUID id) {
        articleRepo.deleteById(id);
        return new Result(true, "Article deleted");
    }
}
