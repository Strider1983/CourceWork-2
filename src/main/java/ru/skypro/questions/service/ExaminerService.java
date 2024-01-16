package ru.skypro.questions.service;

import ru.skypro.questions.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
