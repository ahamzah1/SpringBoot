package com.example.demo.Student;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfiguration {

    @Bean("Student")
    public Student firstStudent(){
        return  new Student("Ahmad", 10 , LocalDate.of(2000, Month.AUGUST, 28),"Test");
    }
}
