package ru.otus.springboot.springBootHomework.dao;

import ru.otus.springboot.springBootHomework.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> getQuestionsFromFile(String path);
}
