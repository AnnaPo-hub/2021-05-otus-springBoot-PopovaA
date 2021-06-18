package ru.otus.springboot.springBootHomework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import ru.otus.springboot.springBootHomework.config.AppConfigs;
import ru.otus.springboot.springBootHomework.utils.QuestionnaireResults;

@SpringBootTest(classes = {QuestionnaireResults.class, AppConfigs.class})
class QuestionnaireResultsTests {

    @Autowired
    private QuestionnaireResults questionnaireResults;

    @Autowired
    private MessageSource messageSource;

    @Test
    void shouldCheckNegativeResult() {
        Assertions.assertFalse(questionnaireResults.showResults( 1));
    }

    @Test
    void shouldCheckPositiveResult() {
        Assertions.assertTrue(questionnaireResults.showResults( 5));
    }
}
