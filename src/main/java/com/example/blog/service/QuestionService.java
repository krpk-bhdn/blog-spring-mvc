package com.example.blog.service;

import com.example.blog.entity.Answer;
import com.example.blog.entity.Question;
import com.example.blog.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void addQuestion(Question question){
        question.setPublicationDate(LocalDateTime.now());
        questionRepository.save(question);
    }

    public void addAnswer(Question question, Answer answer){
        answer.setPublicationDate(LocalDateTime.now());
        question.getAnswers().add(answer);
        questionRepository.save(question);
    }
}
