package ru.otus.springboot.springBootHomework.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Scope;

@Data
@AllArgsConstructor
@Scope("prototype")
public class Question {
    String questionNumber;
    String question;
    String correctResponse;
}
