package org.example.kun_uz.Service;

import org.example.kun_uz.Dto.SavedArticleDto;
import org.example.kun_uz.Repository.ArticleRepo;
import org.example.kun_uz.Repository.ProfileRepo;
import org.example.kun_uz.Repository.SavedArticleRepo;
import org.example.kun_uz.model.Article;
import org.example.kun_uz.model.Profile;
import org.example.kun_uz.model.Result;
import org.example.kun_uz.model.SavedArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavedArticleService {

    @Autowired
    SavedArticleRepo savedArticleRepo;
    @Autowired
    ProfileRepo profileRepo;
    @Autowired
    ArticleRepo articleRepo;

    public List<SavedArticle> getallsavedarticles() {
        return savedArticleRepo.findAll();
    }

    public SavedArticle getsavedarticlebyid(Integer id) {
        return savedArticleRepo.findById(id).get();
    }
    public Result createSavedArticle(SavedArticleDto savedArticleDto) {
        SavedArticle savedArticle = new SavedArticle();

        Optional<Profile> profileOptional= profileRepo.findById(savedArticleDto.getProfile_id());
        Profile profile = profileOptional.get();
        savedArticle.setProfile_id(profile);

        Optional<Article> articleOptional= articleRepo.findById(savedArticleDto.getArticle_id());
        Article article = articleOptional.get();
        savedArticle.setArticle_id(article);

        savedArticleRepo.save(savedArticle);
        return new Result(true, "SavedArticle created");
    }

    public Result updateSavedArticle(Integer id , SavedArticleDto savedArticleDto) {
        Optional<SavedArticle> savedArticleOptional = savedArticleRepo.findById(id);
        if (savedArticleOptional.isPresent()) {
            SavedArticle savedArticle = savedArticleOptional.get();

            Optional<Profile> profileOptional= profileRepo.findById(savedArticleDto.getProfile_id());
            Profile profile = profileOptional.get();
            savedArticle.setProfile_id(profile);

            Optional<Article> articleOptional= articleRepo.findById(savedArticleDto.getArticle_id());
            Article article = articleOptional.get();
            savedArticle.setArticle_id(article);
            savedArticleRepo.save(savedArticle);
            return new Result(true, "SavedArticle updated");
        }
        return new Result(false, "SavedArticle not found");
    }

    public Result deleteSavedArticle(Integer id) {
        savedArticleRepo.deleteById(id);
        return new Result(true, "SavedArticle deleted");
    }
}
