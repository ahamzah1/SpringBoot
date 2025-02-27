package com.example.demo.Student;

import com.example.demo.School.School;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentDto save(StudentDto studentDto) {
        Student student = this.studentMapper.toEntity(studentDto);

        // Create a new School object with only the ID
        if (studentDto.getSchoolId() != null) {
            School school = new School();
            school.setId(studentDto.getSchoolId()); // Only set the ID, no DB call
            student.setSchool(school);
        }

        return this.studentMapper.toDto(this.studentRepository.save(student));
    }


    public Student find(Long id){
        return this.studentRepository.findById(id).orElse(new Student());
    }

    public List<Student> findName(String name){
        return this.studentRepository.findAllByNameContaining(name);
    }

    public List<StudentDto> findALl(){
        return this.studentRepository.findAll().stream().map(this.studentMapper::toDto).collect(Collectors.toList());
    }

    public void delete(Long id){
        this.studentRepository.deleteById(id);
    }

    public Student edit(Long id, Student student) {
        return studentRepository.findById(id)
                .map(existingStudent -> {
                    existingStudent.setName(student.getName()); // Update fields
                    return studentRepository.save(existingStudent); // Save updated student
                })
                .orElseThrow(() -> new RuntimeException("Student not found")); // Handle missing student
    }

}
