package com.example.blog.conrtoller;

import com.example.blog.entity.Article;
import com.example.blog.entity.Comment;
import com.example.blog.entity.SubComment;
import com.example.blog.entity.User;
import com.example.blog.service.ArticleService;
import com.example.blog.service.FileService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/article/{article}")
    public String viewArticle(
            @PathVariable Article article,
            Model model
    ){
        model.addAttribute("article", article);
        return "article";
    }

    @PostMapping("/article/{article}/addComment")
    public String addComment(
            @PathVariable Article article,
            @AuthenticationPrincipal User user,
            @RequestParam String text
    ){
        Comment comment = new Comment(user, text);
        articleService.addComment(article, comment);
        return "redirect:/article/" + article.getId();
    }

    @PostMapping("/article/{article}/{comment}/addSubComment")
    public String addSubComment(
            @PathVariable Article article,
            @PathVariable Comment comment,
            @AuthenticationPrincipal User user,
            @RequestParam String text
    ){
        SubComment subComment = new SubComment(user, text);
        articleService.addSubComment(comment, subComment);
        return "redirect:/article/" + article.getId();
    }

}
