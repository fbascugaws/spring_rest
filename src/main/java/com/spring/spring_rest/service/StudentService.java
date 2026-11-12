package com.spring.spring_rest.service;

import com.spring.spring_rest.dto.StudentDto;
import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id);
    List<StudentDto> getAllStudents();
    StudentDto updateStudent(Long id, StudentDto studentDto);

}
