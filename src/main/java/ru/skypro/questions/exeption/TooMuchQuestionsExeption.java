package ru.skypro.questions.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class TooMuchQuestionsExeption extends RuntimeException{
    public TooMuchQuestionsExeption(String message) {
        super(message);
    }
}
