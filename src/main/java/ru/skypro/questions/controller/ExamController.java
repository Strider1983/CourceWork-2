package ru.skypro.questions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.questions.model.Question;
import ru.skypro.questions.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("get/{amount}")
    public Collection<Question> getQuestions(@PathVariable(value = "amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
