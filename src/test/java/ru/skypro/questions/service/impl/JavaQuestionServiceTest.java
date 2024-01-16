package ru.skypro.questions.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.skypro.questions.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class JavaQuestionServiceTest {
    private final JavaQuestionService questionService = new JavaQuestionService();
    @Test
    public void shouldQuestionBeAdded() {
        Question question = new Question("q", "a");
        Question actualQuestion = questionService.add(question);
        Assertions.assertEquals(question, actualQuestion);
    }
    @Test
    public void shouldQuestionBeRemoved() {
        Question question = new Question("q", "a");
        questionService.add(question);
        Question actualQuestion = questionService.remove(question);
        Assertions.assertEquals(question, actualQuestion);
    }
    @Test
    public void shouldGetAll() {
        Set<Question> testQuestions = new HashSet<>();
        testQuestions.add(new Question("q", "a"));
        testQuestions.add(new Question("c", "x"));
        questionService.add("q", "a");
        questionService.add("c", "x");
        Collection<Question> actualQuestions = questionService.getAll();
        Assertions.assertIterableEquals(testQuestions, actualQuestions);


    }


}
