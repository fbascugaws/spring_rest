package com.spring.spring_rest.service;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.StudentNotFoundException;
import com.spring.spring_rest.mapper.StudentMapper;
import com.spring.spring_rest.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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

    /**   
     * Retrieves all Student entities from the database.
     * 
     * @return a list of all students in the database
     */
    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students = studentRepo.findAll();

        return students.stream().map(
            (student) -> StudentMapper.mapToStudentDto(student))
            .collect(Collectors.toList());
    }

    /**   
     * 
     * @param id
     * @param studentDto
     * @return
     */
    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        
        Student student = studentRepo.findById(id)
            .orElseThrow(() -> new StudentNotFoundException(
                "Student id " + id + " not found!"));

        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());

        Student saved = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

}
