package ru.otus.springboot.springBootHomework.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class QuestionnaireResults {

    @Autowired
    private MessageSource messageSource;

    @Value("${locale}")
    private String locale;

    public boolean checkResults(int correctReplyQuantity) {
        final int passed = 3;
        return correctReplyQuantity >= passed;
    }

    public String showResults(String user, boolean results) {
        if (results) {
            return user + ", " + messageSource.getMessage("positiveResult", null, Locale.forLanguageTag(locale));

        } else {
            return user + ", " + messageSource.getMessage("negativeResult", null, Locale.forLanguageTag(locale));
        }
    }
}
