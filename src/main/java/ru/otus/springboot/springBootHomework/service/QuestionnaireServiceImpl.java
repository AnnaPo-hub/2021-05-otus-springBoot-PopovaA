package ru.otus.springboot.springBootHomework.service;

import org.springframework.stereotype.Service;
import ru.otus.springboot.springBootHomework.dao.QuestionDao;
import ru.otus.springboot.springBootHomework.utils.Greeting;
import ru.otus.springboot.springBootHomework.utils.QuestionShow;
import ru.otus.springboot.springBootHomework.utils.QuestionnaireResults;

import java.io.FileNotFoundException;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final Greeting greeting;
    private final QuestionShow questionShow;
    private final QuestionnaireResults questionnaireResults;
    private final QuestionDao questionDao;
    private MessageService messageService;

    public QuestionnaireServiceImpl(Greeting greeting,
                                    QuestionShow questionShow,
                                    QuestionnaireResults questionnaireResults,
                                    QuestionDao questionDao, MessageService messageService) {
        this.greeting = greeting;
        this.questionShow = questionShow;
        this.questionnaireResults = questionnaireResults;
        this.questionDao = questionDao;
        this.messageService = messageService;
    }

    public void startQuestionnaire() throws FileNotFoundException {
        String pathToFile = messageService.getMessage("pathToQuestion");
        String userName = greeting.askUserName();
        boolean results = questionnaireResults.checkResults(questionShow.
                showQuestion(questionDao.getQuestionsFromFile(pathToFile)));
        System.out.println(questionnaireResults.showResults(userName, results));
    }
}
