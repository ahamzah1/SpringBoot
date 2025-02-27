package com.example.demo.StudentProfile;

import com.example.demo.Student.Student;
import jakarta.persistence.*;

@Entity
@Table
public class StudentProfile {
    @Id
    @GeneratedValue
    private int id;
    private String bio;

    @OneToOne(mappedBy = "studentProfile")
    private Student student;

    public StudentProfile(){

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentProfile(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
