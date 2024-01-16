package ru.skypro.questions.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.questions.exeption.TooMuchQuestionsExeption;
import ru.skypro.questions.model.Question;
import ru.skypro.questions.service.ExaminerService;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @Test
    public void shouldThrowTooMuchQuestionsExeption() {
        int amount = 5;
        when(javaQuestionService.getAll()).thenReturn(List.of());
        Assertions.assertThrows(
                TooMuchQuestionsExeption.class,
                () -> examinerService.getQuestions(amount)
        );
    }
    @Test
    public void shouldGetQuestions() {
        int amount = 3;
        List<Question> questions = List.of(
               new Question("q1", "a1"),
               new Question("q2", "a2"),
               new Question("q3", "a3"),
               new Question("q4", "a4")

        );
        when(javaQuestionService.getAll()).thenReturn(questions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                questions.get(0),
                questions.get(1),
                questions.get(1),
                questions.get(0),
                questions.get(1),
                questions.get(2)
        );

        Collection<Question> actualQuestions = examinerService.getQuestions(amount);
        Assertions.assertIterableEquals(
                Set.of(questions.get(0), questions.get(1), questions.get(2)),
                actualQuestions
        );

        verify(javaQuestionService, times(6)).getRandomQuestion();
    }
}
