package com.example.demo.Student;


import jakarta.validation.constraints.NotEmpty;

public class  StudentDto{
    @NotEmpty(message = "name should not be empty!")
    private String name;
    @NotEmpty
    private String email;
    private Integer schoolId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }
}
