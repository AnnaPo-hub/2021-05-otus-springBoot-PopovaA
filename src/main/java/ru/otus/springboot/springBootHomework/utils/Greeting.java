package ru.otus.springboot.springBootHomework.utils;


import org.springframework.stereotype.Service;
import ru.otus.springboot.springBootHomework.service.MessageService;

import java.util.Scanner;

@Service
public class Greeting {

    private final MessageService messageService;

    public Greeting(MessageService messageService) {
        this.messageService = messageService;
    }

    public String askUserName() {
        System.out.println(messageService.getMessage("greeting"));
        Scanner scan = new Scanner(System.in);
        return "Привет, " + scan.nextLine();
    }
}
