package ru.otus.springboot.springBootHomework.dao;

import ru.otus.springboot.springBootHomework.domain.Question;

import java.io.FileNotFoundException;
import java.util.List;

public interface QuestionDao {

    List<Question> getQuestionsFromFile(String path) throws FileNotFoundException;
}
