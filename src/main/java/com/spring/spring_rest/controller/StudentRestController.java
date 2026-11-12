package com.spring.spring_rest.controller;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.service.StudentService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


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

    /**
     * 
     * @return
     */
    @GetMapping 
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        
        List<StudentDto> students = studentService.getAllStudents();

        return ResponseEntity.ok(students);
    }


    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, 
            @Valid @RequestBody StudentDto theStudentDto) {
        
        StudentDto studentDto = studentService.updateStudent
            (id, theStudentDto);
        
        return ResponseEntity.ok(studentDto);
    }


    @PatchMapping ("{id}")
    public ResponseEntity<StudentDto> patchStudent(@PathVariable Long id, 
            @Valid @RequestBody StudentDto theStudentDto) {
        
        StudentDto studentDto = studentService.patchStudent(id, theStudentDto);
        
        return ResponseEntity.ok(studentDto);
    }


    @DeleteMapping ("{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        
        studentService.deleteStudentById(id);
        
        return ResponseEntity.ok("Student deleted successfully!");
    }

}
