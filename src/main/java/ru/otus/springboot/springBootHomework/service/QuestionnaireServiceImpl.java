package ru.otus.springboot.springBootHomework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.springboot.springBootHomework.config.AppConfig;
import ru.otus.springboot.springBootHomework.dao.QuestionDao;
import ru.otus.springboot.springBootHomework.utils.Greeting;
import ru.otus.springboot.springBootHomework.utils.QuestionShow;
import ru.otus.springboot.springBootHomework.utils.QuestionnaireResults;

import java.io.FileNotFoundException;
import java.util.Locale;

@Service
//@PropertySource("classpath:application.properties")
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final Greeting greeting;
    private final QuestionShow questionShow;
    private final QuestionnaireResults questionnaireResults;
    private final QuestionDao questionDao;
    @Autowired
    private AppConfig appConfig;

    @Autowired
    private MessageSource messageSource;



    public QuestionnaireServiceImpl(@Qualifier("askUserName") Greeting greeting,
                                    @Qualifier("questionShow") QuestionShow questionShow,
                                    @Qualifier("results") QuestionnaireResults questionnaireResults,
                                    @Qualifier("questionDao") QuestionDao questionDao) {
        this.greeting = greeting;
        this.questionShow = questionShow;
        this.questionnaireResults = questionnaireResults;
        this.questionDao = questionDao;
    }

    public void startQuestionnaire() throws FileNotFoundException {
        questionnaireResults.showResults(greeting.askUserName(),
                questionShow.showQuestion(questionDao.getQuestionsFromFile(messageSource.getMessage("pathToQuestion", null,  Locale.forLanguageTag("ru-RU")))));
    }
}
