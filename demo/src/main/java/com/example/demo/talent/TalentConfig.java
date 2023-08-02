package com.example.demo.talent;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class TalentConfig {

    @Bean
    CommandLineRunner commandLineRunner(TalentRepository repository) {
        return args -> {
            Talent adriel = new Talent(
                    "Adriel",
                    "adriel.osorio@gmail.com",
                    "Lyceum of the Philippines University",
                    "4th year college",
                    LocalDate.of(1999, NOVEMBER, 16)
            );
            Talent claire = new Talent(
                    "Claire",
                    "claire.ramos@gmail.com",
                    "Jose Rizal University",
                    "3rd Year College",
                    LocalDate.of(2003, AUGUST, 5)
            );

            repository.saveAll(
                    List.of(adriel, claire)
            );
        };
    }
}
