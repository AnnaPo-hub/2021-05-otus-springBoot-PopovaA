package ru.otus.springboot.springBootHomework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.springboot.springBootHomework.dao.QuestionDaoSimple;

import java.io.FileNotFoundException;

@SpringBootTest(classes = QuestionDaoSimple.class)
class SpringBootHomeworkApplicationTests {

//	@Autowired
//	QuestionnaireResults questionnaireResults;

	@Autowired
	private QuestionDaoSimple questionDaoSimple;

//	@Autowired
//	private MessageSource messageSource;

	@Test
	void contextLoads() throws FileNotFoundException {
		//Assertions.assertFalse(	questionnaireResults.showResults("Ivan Ivanov", 1));

		Assertions.assertEquals(5, questionDaoSimple.getQuestionsFromFile("target/classes/questionnaire.csv").size());
	}

}
