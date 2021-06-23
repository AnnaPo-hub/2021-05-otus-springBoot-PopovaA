package ru.otus.springboot.springBootHomework;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.otus.springboot.springBootHomework.service.QuestionnaireService;
import ru.otus.springboot.springBootHomework.utils.Greeting;

@ShellComponent
public class HelloShell {

    private final Greeting greeting;
    private final QuestionnaireService service;
    String userName;

    public HelloShell(Greeting greeting, QuestionnaireService service) {
        this.greeting = greeting;
        this.service = service;
    }

    @ShellMethod(value ="Login", key = {"login", "l"})
    public String askName() {
        return userName = greeting.askUserName();
    }

    @ShellMethod(value = "Start the questionnaire", key = {"start", "s"})
    @ShellMethodAvailability(value = "isLoginUser")
    public void startQuestionnaire() {
        service.startQuestionnaire(userName.replace("Привет, ", ""));
    }

    private Availability isLoginUser() {
        return userName == null ? Availability.unavailable("Залогиньтесь перед тестированием, используя команду login") : Availability.available();
    }
}
