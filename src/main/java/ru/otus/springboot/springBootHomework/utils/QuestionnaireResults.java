package ru.otus.springboot.springBootHomework.utils;

import org.springframework.context.annotation.Configuration;
import ru.otus.springboot.springBootHomework.service.MessageService;

@Configuration
public class QuestionnaireResults {


    private final MessageService messageService;

    public QuestionnaireResults(MessageService messageService) {
        this.messageService = messageService;
    }

    public boolean checkResults(int correctReplyQuantity) {
        final int passed = 3;
        return correctReplyQuantity >= passed;
    }

    public String showResults(String user, boolean results) {
        if (results) {
            return user + ", " + messageService.getMessage("positiveResult");

        } else {
            return user + ", " + messageService.getMessage("negativeResult");
        }
    }
}
