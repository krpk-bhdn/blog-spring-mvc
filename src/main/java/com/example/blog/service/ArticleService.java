package com.example.blog.service;

import com.example.blog.entity.Article;
import com.example.blog.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void addArticle(Article article) {

        article.setPublicationDate(LocalDateTime.now());
        articleRepository.save(article);
    }
}
