package com.example.blog.conrtoller;

import com.example.blog.entity.Article;
import com.example.blog.entity.User;
import com.example.blog.service.ArticleService;
import com.example.blog.service.FileService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/article")
public class ArticleController {
    private final FileService fileService;
    private final ArticleService articleService;

    public ArticleController(FileService fileService, ArticleService articleService) {
        this.fileService = fileService;
        this.articleService = articleService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String article(){
        return "addArticle";
    }

    @GetMapping("{article}")
    public String viewArticle(
            @PathVariable Article article,
            Model model
    ){
        model.addAttribute("article", article);
        return "article";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addArticle(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam String text,
            @RequestParam("file") MultipartFile file,
            Model model
            ) throws IOException {
        Article article = new Article(title, text, user);
        article.setFilename(fileService.uploadFile(file));

        articleService.addArticle(article);

        return "redirect:/";
    }

}
