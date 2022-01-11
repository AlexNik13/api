package com.example.api.students;


import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfiguration {


  /*  @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            studentRepository.saveAll(List.of(
                    new Student("Alex", "myEmail@gmail.com", LocalDate.of (2000, Month.JANUARY, 1)),
                    new Student("Tom", "mailTom@yandex.ru",LocalDate.of (2002, Month.MARCH, 6))
            ));
        };
    }*/
}
