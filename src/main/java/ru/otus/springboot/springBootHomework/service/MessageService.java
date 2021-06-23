package ru.otus.springboot.springBootHomework.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
@Service
public class MessageService {
    private final MessageSource messageSource;
    private Locale locale;

    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
        this.locale = Locale.forLanguageTag("ru_Ru");
    }

    public String getMessage(final String messageName) {
        return messageSource.getMessage(messageName, new String[]{}, locale);
    }
}
