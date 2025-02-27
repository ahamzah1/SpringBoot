package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public  StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/{student-id}")
    public Student getStudents(@PathVariable("student-id") Long id){
            return studentService.find(id);
    }

    @PostMapping()
    public ResponseEntity<StudentDto> post(@RequestBody StudentDto student ){
        return ResponseEntity.ok(studentService.save(student));
    }

    @GetMapping()
    public List<StudentDto> getStudents(){
        return this.studentService.findALl();
    }

    @DeleteMapping("delete/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("student-id") Long id){
        this.studentService.delete(id);
    }

    @PutMapping("edit/{student-id}")
    public Student edit(@PathVariable("student-id") Long id ,@RequestBody Student student){
        return this.studentService.edit(id,student);
    }


}
