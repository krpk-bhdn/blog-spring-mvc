package com.example.blog.repository;

import com.example.blog.entity.Article;
import com.example.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByAuthor(User user);
    List<Article> findByVerifyTrue();
    List<Article> findByVerifyFalse();
    Long countByVerifyTrue();
}
