package ru.otus.springboot.springBootHomework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.springboot.springBootHomework.dao.QuestionDaoSimple;

import java.io.FileNotFoundException;

@SpringBootTest(classes = QuestionDaoSimple.class)
class SpringBootHomeworkApplicationTests {

	@Autowired
	private QuestionDaoSimple questionDaoSimple;

	@Test
	void contextLoads() throws FileNotFoundException {
		Assertions.assertEquals(5, questionDaoSimple.getQuestionsFromFile("target/classes/questionnaire.csv").size());
	}
}