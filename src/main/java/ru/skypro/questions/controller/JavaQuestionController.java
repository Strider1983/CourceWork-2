package ru.skypro.questions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.questions.model.Question;
import ru.skypro.questions.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("exam/java")
public class JavaQuestionController {
    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    private final QuestionService questionService;

    @GetMapping("add")
    public Question add(String question, String answer) {
        return questionService.add(question, answer);
    }
    @GetMapping("remove")
    public Question remove(String question, String answer) {
        return questionService.remove(new Question(question, answer));
    }
    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

}
