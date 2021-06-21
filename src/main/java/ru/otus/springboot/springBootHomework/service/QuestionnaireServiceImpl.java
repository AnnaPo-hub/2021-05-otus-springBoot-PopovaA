package ru.otus.springboot.springBootHomework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.springboot.springBootHomework.dao.QuestionDao;
import ru.otus.springboot.springBootHomework.utils.Greeting;
import ru.otus.springboot.springBootHomework.utils.QuestionShow;
import ru.otus.springboot.springBootHomework.utils.QuestionnaireResults;

import java.io.FileNotFoundException;
import java.util.Locale;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final Greeting greeting;
    private final QuestionShow questionShow;
    private final QuestionnaireResults questionnaireResults;
    private final QuestionDao questionDao;

    @Autowired
    private MessageSource messageSource;


    public QuestionnaireServiceImpl(Greeting greeting,
                                    QuestionShow questionShow,
                                    QuestionnaireResults questionnaireResults,
                                    QuestionDao questionDao) {
        this.greeting = greeting;
        this.questionShow = questionShow;
        this.questionnaireResults = questionnaireResults;
        this.questionDao = questionDao;
    }

    public void startQuestionnaire() throws FileNotFoundException {
        questionnaireResults.showResults(questionShow.showQuestion(questionDao.getQuestionsFromFile(messageSource.getMessage("pathToQuestion", null, Locale.forLanguageTag("ru-Ru")))));
    }
}
