package org.example.kun_uz.Service;

import org.example.kun_uz.Dto.Article_typeDto;
import org.example.kun_uz.Repository.Article_typeRepo;
import org.example.kun_uz.model.Article_type;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Article_typeService {

    @Autowired
    Article_typeRepo article_typeRepo;

    public List<Article_type> findAll() {
        return article_typeRepo.findAll();
    }

    public Article_type findById(Integer id) {
        return article_typeRepo.findById(id).get();
    }

    public Result save(Article_typeDto article_typeDto) {
        Article_type article_type = new Article_type();
        article_type.setOrder_number(article_typeDto.getOrder_number());
        article_type.setName_uz(article_typeDto.getName_uz());
        article_type.setName_ru(article_typeDto.getName_ru());
        article_type.setName_eng(article_typeDto.getName_eng());
        article_type.setCreated_date(article_typeDto.getCreated_date());
        article_typeRepo.save(article_type);
        return new Result(true, "Article_type created");
    }

    public Result update(Integer id , Article_typeDto article_typeDto) {
        Optional<Article_type> articleTypeOptional = article_typeRepo.findById(id);
        if (articleTypeOptional.isPresent()) {
            Article_type article_type = articleTypeOptional.get();
            article_type.setOrder_number(article_typeDto.getOrder_number());
            article_type.setName_uz(article_typeDto.getName_uz());
            article_type.setName_ru(article_typeDto.getName_ru());
            article_type.setName_eng(article_typeDto.getName_eng());
            article_type.setCreated_date(article_typeDto.getCreated_date());
            article_typeRepo.save(article_type);
            return new Result(true, "Article_type updated");
        }
        return new Result(false, "Article_type not found");
    }
    public Result delete(Integer id) {
        article_typeRepo.deleteById(id);
        return new Result(true, "Article_type deleted");
    }
}
