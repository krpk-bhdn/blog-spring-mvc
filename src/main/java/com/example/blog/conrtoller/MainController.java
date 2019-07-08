package com.example.blog.conrtoller;

import com.example.blog.entity.Article;
import com.example.blog.repository.ArticleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private final ArticleRepository articleRepository;

    public MainController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/blog")
    public String blog(Model model){
        List<Article> articles = articleRepository.findByVerifyTrueOrderByPublicationDateDesc();
        model.addAttribute("articles", articles);
        return "blog";
    }
}
