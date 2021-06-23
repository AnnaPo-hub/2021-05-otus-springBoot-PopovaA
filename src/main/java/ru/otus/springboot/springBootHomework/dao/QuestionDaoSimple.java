package ru.otus.springboot.springBootHomework.dao;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Component;
import ru.otus.springboot.springBootHomework.domain.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class QuestionDaoSimple implements QuestionDao {
    @Override
    public List<Question> getQuestionsFromFile(@NotNull String path) {
        List<Question> questions = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("Pls check path to the file, the file was not found ");
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            String nextQuestion = scanner.nextLine();
            String[] parts = nextQuestion.split(", ");
            Question question = new Question(parts[0], parts[1], parts[2]);
            questions.add(question);
        }
        return questions;
    }
}
