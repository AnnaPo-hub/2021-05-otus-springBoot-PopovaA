package ru.otus.springboot.springBootHomework;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.springboot.springBootHomework.service.QuestionnaireService;
import ru.otus.springboot.springBootHomework.utils.Greeting;

import java.io.FileNotFoundException;

@ShellComponent
public class HelloShell {

    private final Greeting greeting;

    private final QuestionnaireService service;

    public HelloShell(Greeting greeting, QuestionnaireService service) {
        this.greeting = greeting;
        this.service = service;
    }

    @ShellMethod("Ask the question")
    public void askQuestions() throws FileNotFoundException {
        service.startQuestionnaire();
    }

    @ShellMethod("Ask a user's name and surname")
    public String askName() {
        return greeting.askUserName();
    }
}
