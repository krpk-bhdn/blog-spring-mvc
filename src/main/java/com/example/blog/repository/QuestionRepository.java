package com.example.blog.repository;

import com.example.blog.entity.Category;
import com.example.blog.entity.Question;
import com.example.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByAuthor(User user);
    List<Question> findByVerifyTrueAndCategories(Category category);
    List<Question> findByVerifyTrueAndCategoriesAndTitleContains(Category category, String title);
    List<Question> findByVerifyFalse();
    Long countByVerifyTrue();
}
