package com.example.blog.service;

import com.example.blog.entity.Article;
import com.example.blog.entity.Comment;
import com.example.blog.entity.SubComment;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public ArticleService(ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

    public void addArticle(Article article) {

        article.setPublicationDate(LocalDateTime.now());
        articleRepository.save(article);
    }

    public void addComment(Article article, Comment comment) {
        article.getComments().add(comment);
        articleRepository.save(article);
    }

    public void addSubComment(Comment comment, SubComment subComment) {
        comment.getSubComments().add(subComment);
        commentRepository.save(comment);
    }
}
