package com.example.demo.Student;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "school.id", target = "schoolId")
    StudentDto toDto(Student student);

    @Mapping(target = "school", ignore = true)
    Student toEntity(StudentDto studentDto);
}
