package ru.otus.springboot.springBootHomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.springboot.springBootHomework.service.QuestionnaireService;

import java.io.FileNotFoundException;

@SpringBootApplication
public class SpringBootHomeworkApplication {
    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(SpringBootHomeworkApplication.class, args);
        ApplicationContext ctx = SpringApplication.run(SpringBootHomeworkApplication.class);
        QuestionnaireService service = ctx.getBean(QuestionnaireService.class);
        service.startQuestionnaire();
    }
}
