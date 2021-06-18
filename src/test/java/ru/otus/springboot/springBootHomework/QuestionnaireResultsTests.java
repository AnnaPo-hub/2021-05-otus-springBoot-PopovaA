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
        Assertions.assertFalse(questionnaireResults.checkResults( 1));
    }

    @Test
    void shouldCheckPositiveResult() {
        Assertions.assertTrue(questionnaireResults.checkResults( 5));
    }

    @Test
    void shouldPrintNegativeResult() {
        Assertions.assertEquals("Dear Ivan Ivanov, you have not passed the test. Invite your friends and watch the Lord of the Rings trilogy again.",
                questionnaireResults.showResults("Ivan Ivanov", false));
    }

    @Test
    void shouldPrintPositiveResult() {
        Assertions.assertEquals("Dear Ivan Ivanov, congratulations!You have passed the test!",
                questionnaireResults.showResults("Ivan Ivanov", true));
    }
}
