package com.example.blog.conrtoller;

import com.example.blog.entity.Answer;
import com.example.blog.entity.Category;
import com.example.blog.entity.Question;
import com.example.blog.entity.User;
import com.example.blog.repository.QuestionRepository;
import com.example.blog.service.QuestionService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ForumController {

    private final QuestionRepository questionRepository;
    private final QuestionService questionService;

    public ForumController(
            QuestionRepository questionRepository,
            QuestionService questionService
    ) {
        this.questionRepository = questionRepository;
        this.questionService = questionService;
    }

    @GetMapping("/forum")
    public String showForumDiscussion(Model model){
        List<Question> discussions = questionRepository.findByVerifyTrueAndCategories(Category.DISCUSSION);
        model.addAttribute("discussions", discussions);
        return "forumDiscussion";
    }

    @GetMapping("/forum/support")
    public String showForumSupport(Model model){
        List<Question> supports = questionRepository.findByVerifyTrueAndCategories(Category.SUPPORT);
        model.addAttribute("supports", supports);
        return "forumSupport";
    }

    @GetMapping("/forum/{question}")
    public String question(@PathVariable Question question, Model model){
        model.addAttribute("question", question);
        return "forumQuestion";
    }

    @PostMapping("/forum/{question}")
    public String addAnswer(
            @AuthenticationPrincipal User user,
            @PathVariable Question question,
            @RequestParam String text
    ){
        Answer answer = new Answer(text, user);
        questionService.addAnswer(question, answer);
        return "redirect:/forum/" + question.getId();
    }

    @PostMapping("/forum")
    public String showForumSelectDiscussion(@RequestParam String title, Model model){
        List<Question> discussions =
                questionRepository.findByVerifyTrueAndCategoriesAndTitleContains(Category.DISCUSSION, title);
        model.addAttribute("discussions", discussions);
        return "forumDiscussion";
    }

    @PostMapping("/forum/support")
    public String showForumSupport(@RequestParam String title, Model model){
        List<Question> supports =
                questionRepository.findByVerifyTrueAndCategoriesAndTitleContains(Category.SUPPORT, title);
        model.addAttribute("supports", supports);
        return "forumSupport";
    }
}
