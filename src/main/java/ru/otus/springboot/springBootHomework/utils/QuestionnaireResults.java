package ru.otus.springboot.springBootHomework.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration("results")
public class QuestionnaireResults {

    @Autowired
    private MessageSource messageSource;

    public boolean showResults(int correctReplyQuantity) {
        final int passed = 3;
        if (correctReplyQuantity >= passed) {
            System.out.println(messageSource.getMessage("positiveResult", null, Locale.forLanguageTag("ru-RU")));
            return true;
        } else {
            System.out.println(messageSource.getMessage("negativeResult", null, Locale.forLanguageTag("ru-RU")));
            return false;
        }
    }
}
