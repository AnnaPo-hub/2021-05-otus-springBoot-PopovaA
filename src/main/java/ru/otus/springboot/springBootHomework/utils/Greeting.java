package ru.otus.springboot.springBootHomework.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.Scanner;

@Configuration
public class Greeting {
    @Autowired
    MessageSource messageSource;

    public String askUserName() {
        System.out.println(messageSource.getMessage("greeting", null,  Locale.forLanguageTag("ru-RU")));
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
