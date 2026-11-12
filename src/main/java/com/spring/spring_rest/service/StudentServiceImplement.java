package com.spring.spring_rest.service;

import org.springframework.stereotype.Service;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.StudentNotFoundException;
import com.spring.spring_rest.mapper.StudentMapper;
import com.spring.spring_rest.repository.StudentRepository;

/**
 * StudentServiceImplement
 * 
 * TODO
 */
@Service 
public class StudentServiceImplement implements StudentService {

    private StudentRepository studentRepo;    

    public StudentServiceImplement(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    /**    
     * TODO
     * 
     * @return 
     */
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student saved = studentRepo.save(student);
        
        return StudentMapper.mapToStudentDto(saved);
    }


    @Override
    public StudentDto getStudentById(Long id) {
        
        Student student = studentRepo.findById(id)
            .orElseThrow(() -> new StudentNotFoundException
                ("Student id " + id + " not found!"));
        
        return StudentMapper.mapToStudentDto(student);
    }

}
