package com.example.demo.Student;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public ResponseEntity<StudentDto> post(@Valid @RequestBody StudentDto student ){
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        HashMap<String,String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error-> {
            var fieldName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);

    }

}
