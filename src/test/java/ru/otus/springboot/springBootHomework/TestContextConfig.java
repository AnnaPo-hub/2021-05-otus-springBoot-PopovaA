package ru.otus.springboot.springBootHomework;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@EnableConfigurationProperties
@ComponentScan({"ru.otus.springboot.springBootHomework.dao", "ru.otus.springboot.springBootHomework.domain",
        "ru.otus.springboot.springBootHomework.service", "ru.otus.springboot.springBootHomework.utils", "ru.otus.springboot.springBootHomework.config"})
public class TestContextConfig {
}
