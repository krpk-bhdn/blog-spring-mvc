package com.example.blog.conrtoller;

import com.example.blog.entity.Article;
import com.example.blog.entity.Category;
import com.example.blog.entity.Question;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.repository.QuestionRepository;
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
    private final QuestionRepository questionRepository;

    public ModerationController(
            ArticleRepository articleRepository,
            QuestionRepository questionRepository
    ) {
        this.articleRepository = articleRepository;
        this.questionRepository = questionRepository;
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

    @GetMapping("/moderation/question")
    public String moderationQuestion(Model model){
        List<Question> questions = questionRepository.findByVerifyFalse();
        model.addAttribute("questions", questions);
        return "moderationQuestionTable";
    }

    @GetMapping("/moderation/question/confirm/{question}")
    public String confirmQuestion(@PathVariable Question question){
        question.setVerify(true);
        questionRepository.save(question);
        return "redirect:/moderation/question";
    }
}