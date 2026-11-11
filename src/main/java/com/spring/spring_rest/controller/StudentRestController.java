package com.spring.spring_rest.controller;

import com.spring.spring_rest.entity.Student;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * StudentRestController
 */
@RestController 
@RequestMapping ("/api")
public class StudentRestController {

    private List<Student> theStudents;


    @PostConstruct 
    public void initialize() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Chiaki", "Nanami"));
        theStudents.add(new Student("Hajime", "Hinata"));
        theStudents.add(new Student("Nagito", "Komaeda"));

    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }


    @GetMapping("/students/{studentId}")
    public Student getMethodName(@PathVariable int studentId) {
        return theStudents.get(studentId);
    }
    

}
