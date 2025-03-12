package org.example.kun_uz.Service;

import org.example.kun_uz.Dto.ArticleLikeDto;
import org.example.kun_uz.Repository.ArticleLikeRepo;
import org.example.kun_uz.Repository.ArticleRepo;
import org.example.kun_uz.Repository.ProfileRepo;
import org.example.kun_uz.model.Article;
import org.example.kun_uz.model.ArticleLike;
import org.example.kun_uz.model.Profile;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleLikeService {

    @Autowired
    ArticleLikeRepo articleLikeRepo;
    @Autowired
    ArticleRepo articleRepo;
    @Autowired
    ProfileRepo profileRepo;

    public List<ArticleLike> getAllArticleLikes() {
        return articleLikeRepo.findAll();
    }

    public ArticleLike getArticleLike(Integer id) {
        return articleLikeRepo.findById(id).get();
    }
    public Result createArticleLike(ArticleLikeDto articleLikeDto) {
        ArticleLike articleLike = new ArticleLike();
        Optional<Article> articleOptional=articleRepo.findById(articleLikeDto.getArticleid());
        Article article=articleOptional.get();
        articleLike.setArticleid((List<Article>) article);

        Optional<Profile> profileOptional= profileRepo.findById(articleLikeDto.getProfiles());
        Profile profile=profileOptional.get();
        articleLike.setProfiles((List<Profile>) profile);
        articleLikeRepo.save(articleLike);
        return new Result(true, "Article Like created");

    }

    public Result updateArticleLike(Integer id , ArticleLikeDto articleLikeDto) {
        Optional<ArticleLike> articleLikeOptional=articleLikeRepo.findById(id);
        if (articleLikeOptional.isPresent()) {
            ArticleLike articleLike=articleLikeOptional.get();
            Optional<Profile> profileOptional=profileRepo.findById(articleLikeDto.getProfiles());
            Profile profile=profileOptional.get();
            articleLike.setProfiles((List<Profile>) profile);

            Optional<Article> articleOptional=articleRepo.findById(articleLikeDto.getArticleid());
            Article article=articleOptional.get();
            articleLike.setArticleid((List<Article>) article);
            articleLikeRepo.save(articleLike);
            return new Result(true, "Article Like updated");

        }
        return new Result(false, "Article Like not found");
    }

    public Result deleteArticleLike(Integer id) {
        articleLikeRepo.deleteById(id);
        return new Result(true, "Article Like deleted");
    }
}
