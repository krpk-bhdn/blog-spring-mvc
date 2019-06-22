package com.example.blog.conrtoller;

import com.example.blog.entity.Article;
import com.example.blog.repository.ArticleRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MODERATOR')")
public class ModerationController {

    private final ArticleRepository articleRepository;

    public ModerationController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/moderation")
    public String moderation(Model model){
        List<Article> articles = articleRepository.findByVerifyFalse();
        model.addAttribute("articles", articles);
        return "moderationArticleTable";
    }

    @GetMapping("/moderation/confirm/{article}")
    public String confirmArticle(@PathVariable Article article){
        article.setVerify(true);
        articleRepository.save(article);
        return "redirect:/moderation";
    }
}