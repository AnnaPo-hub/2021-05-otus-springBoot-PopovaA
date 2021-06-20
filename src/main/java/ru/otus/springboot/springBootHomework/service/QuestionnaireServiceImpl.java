package ru.otus.springboot.springBootHomework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.otus.springboot.springBootHomework.dao.QuestionDao;
import ru.otus.springboot.springBootHomework.utils.Greeting;
import ru.otus.springboot.springBootHomework.utils.QuestionShow;
import ru.otus.springboot.springBootHomework.utils.QuestionnaireResults;

import java.io.FileNotFoundException;
import java.util.Locale;

@Service
@PropertySource("classpath:app.properties")
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final Greeting greeting;
    private final QuestionShow questionShow;
    private final QuestionnaireResults questionnaireResults;
    private final QuestionDao questionDao;

    @Autowired
    private MessageSource messageSource;

    @Value("${locale}")
    private String locale;


    public QuestionnaireServiceImpl(Greeting greeting,
                                    QuestionShow questionShow,
                                    QuestionnaireResults questionnaireResults,
                                    QuestionDao questionDao, MessageSource messageSource) {
        this.greeting = greeting;
        this.questionShow = questionShow;
        this.questionnaireResults = questionnaireResults;
        this.questionDao = questionDao;
        this.messageSource = messageSource;
    }

    public void startQuestionnaire() throws FileNotFoundException {
        String pathToFile = messageSource.getMessage("pathToQuestion", null, Locale.forLanguageTag(locale));
        String userName = greeting.askUserName();
        boolean results = questionnaireResults.checkResults(questionShow.
                showQuestion(questionDao.getQuestionsFromFile(pathToFile)));
        System.out.println(questionnaireResults.showResults(userName, results));
    }
}
