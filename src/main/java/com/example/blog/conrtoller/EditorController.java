package com.example.blog.conrtoller;

import com.example.blog.entity.Article;
import com.example.blog.entity.Category;
import com.example.blog.entity.Question;
import com.example.blog.entity.User;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.repository.QuestionRepository;
import com.example.blog.service.ArticleService;
import com.example.blog.service.FileService;
import com.example.blog.service.QuestionService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/editor")
public class EditorController {

    private final ArticleRepository articleRepository;
    private final ArticleService articleService;
    private final QuestionRepository questionRepository;
    private final QuestionService questionService;
    private final FileService fileService;

    public EditorController(
            ArticleRepository articleRepository,
            ArticleService articleService,
            QuestionRepository questionRepository,
            QuestionService questionService,
            FileService fileService
    ) {
        this.articleRepository = articleRepository;
        this.articleService = articleService;
        this.questionRepository = questionRepository;
        this.questionService = questionService;
        this.fileService = fileService;
    }

    @GetMapping
    public String articleList(
            @AuthenticationPrincipal User user,
            Model model
    ){
        List<Article> articles;
        if (user.isAdmin() || user.isModerator()) {
            articles = articleRepository.findAll();
        } else {
            articles = articleRepository.findByAuthor(user);
        }
        model.addAttribute("articles", articles);
        return "editor";
    }

    @GetMapping("/add")
    public String editorAddArticle(){
        return "addArticle";
    }

    @GetMapping("/edit/{article}")
    public String editorArticle(
            @PathVariable Article article,
            Model model
    ){
        model.addAttribute("article", article);
        return "editArticle";
    }

    @GetMapping("/question")
    public String questionsList(
            @AuthenticationPrincipal User user,
            Model model
    ){
        List<Question> questions;
        if (user.isAdmin() || user.isModerator()) {
            questions = questionRepository.findAll();
        } else {
            questions = questionRepository.findByAuthor(user);
        }
        model.addAttribute("questions", questions);
        return "question";
    }

    @GetMapping("/question/add")
    public String editorAddQuestion(){
        return "addQuestion";
    }

    @GetMapping("/question/edit/{question}")
    public String editorQuestion(
            @PathVariable Question question,
            Model model
    ){
        model.addAttribute("question", question);
        return "editQuestion";
    }

    @PostMapping("/add")
    public String addArticle(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam String text,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Article article = new Article(title, text, user);
        article.setFilename(fileService.uploadFile(file, false));
        article.setVerify(user.isAdmin() || user.isModerator());

        articleService.addArticle(article);

        return "redirect:/editor";
    }

    @PostMapping("/edit/{article}")
    public String editArticle(
            @PathVariable Article article,
            @RequestParam String title,
            @RequestParam String text
    ){
        if (title != null && !title.isEmpty()){
            article.setTitle(title);
        }
        if (text!=null && !text.isEmpty()){
            article.setText(text);
        }

        articleRepository.save(article);

        return "redirect:/editor";
    }

    @GetMapping("/delete/{article}")
    public String deleteArticle(@PathVariable Article article){
        articleRepository.delete(article);
        return "redirect:/editor";
    }

    @PostMapping("/question/add")
    public String addQuestion(
            @AuthenticationPrincipal User user,
            @RequestParam Map<String, String> form
    ){
        Question question = new Question(form.get("title"), form.get("text"), user);

        Set<String> category = Arrays.stream(Category.values())
                .map(Category::name)
                .collect(Collectors.toSet());

        for(String key : form.values()){
            if (category.contains(key)){
                question.setCategories(Collections.singleton(Category.valueOf(key)));
                break;
            }
        }
        question.setVerify(user.isAdmin() || user.isModerator());

        questionService.addQuestion(question);

        return "redirect:/editor/question";
    }

    @PostMapping("/question/edit/{question}")
    public String editQuestion(
            @PathVariable Question question,
            @RequestParam String title,
            @RequestParam String text
    ){
        if (title != null && !title.isEmpty()){
            question.setTitle(title);
        }
        if (text!=null && !text.isEmpty()){
            question.setText(text);
        }

        questionRepository.save(question);

        return "redirect:/editor/question";
    }

    @GetMapping("/question/delete/{question}")
    public String deleteArticle(@PathVariable Question question){
        questionRepository.delete(question);
        return "redirect:/editor/question";
    }

}
