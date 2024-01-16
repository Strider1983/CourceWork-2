package ru.skypro.questions.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.questions.exeption.TooMuchQuestionsExeption;
import ru.skypro.questions.model.Question;
import ru.skypro.questions.service.ExaminerService;
import ru.skypro.questions.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service

public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new TooMuchQuestionsExeption("превышено количество вопросов");
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
