package com.example.api.students;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;
    private LocalDate dob;

    public Student() {
    }

    public Student(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public int getAge(){
        return Period.between(dob, LocalDate.now() ).getYears();
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
}
