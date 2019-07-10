package com.example.blog.conrtoller;

import com.example.blog.entity.Article;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.repository.QuestionRepository;
import com.example.blog.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private final ArticleRepository articleRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public MainController(
            ArticleRepository articleRepository,
            QuestionRepository questionRepository,
            UserRepository userRepository
    ) {
        this.articleRepository = articleRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String main(Model model){
        long countArticle = articleRepository.countByVerifyTrue();
        long countQuestion = questionRepository.countByVerifyTrue();
        long countUser = userRepository.countUserBy();

        model.addAttribute("countArticle", countArticle);
        model.addAttribute("countQuestion", countQuestion);
        model.addAttribute("countUser", countUser);

        return "main";
    }

    @GetMapping("/blog")
    public String blog(Model model){
        List<Article> articles = articleRepository.findByVerifyTrue();
        model.addAttribute("articles", articles);
        return "blog";
    }
}
