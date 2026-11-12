package com.spring.spring_rest.controller;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * StudentRestController
 * 
 * TODO desc
 * 
 * @author Felisa Bascug
 */
@RestController 
@RequestMapping ("/api/students")
public class StudentRestController {

    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * TODO add desc
     * 
     * @param studentDto JSON payload which is converted into StudentDto
     * @return the ReponseEntity including student data and HTTP status
     */
    @PostMapping
    public ResponseEntity<StudentDto> createStudents(
            @Valid @RequestBody StudentDto studentDto) {
        
        StudentDto saved = studentService.createStudent(studentDto);
        
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    
    /**
     * 
     * @param id the student id
     * @return the found student and HTTP status
     */
    @GetMapping ("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        
        StudentDto studentDto = studentService.getStudentById(id);

        return ResponseEntity.ok(studentDto);
    }

}
