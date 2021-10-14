package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    //Podemos escrever algumas coisas depois que ja estiver rodando
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student maria = new Student( //para exibir o que precisa so colocar ctrl+p
                    "Maria",
                    "JOnes",
                    "maria.jones@gmaol.com",
                    25
            );
            studentRepository.save(maria);
        };
    }
}
