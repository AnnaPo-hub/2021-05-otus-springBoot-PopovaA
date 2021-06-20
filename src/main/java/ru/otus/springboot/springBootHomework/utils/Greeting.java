package ru.otus.springboot.springBootHomework.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;

@Service
public class Greeting {
    @Autowired
    MessageSource messageSource;

    @Value("${locale}")
    private String locale;

    public String askUserName() {
        System.out.println(messageSource.getMessage("greeting", null, Locale.forLanguageTag(locale)));
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
