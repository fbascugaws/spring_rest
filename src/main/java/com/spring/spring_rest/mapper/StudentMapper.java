package com.spring.spring_rest.mapper;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;

/**
 * StudentMapper
 * 
 * Contains methods that map the StudentDto to Student and vice versa.
 * Automates the tedious process of moving data between an entity and DTO 
 * rather than writing manually boilerplate code.
 * 
 * @author Felisa Bascug
 */
public class StudentMapper {

    /**
     * Maps a Student object to a StudentDto object.
     * 
     * @param student
     * @return mapped StudentDto object
     */
    public static StudentDto mapToStudentDto(Student student) {
        return new StudentDto(student.getId(), student.getFirstName(), 
                            student.getLastName(), student.getEmail());
    }

    /**
     * Maps a StudentDto object to a Student object.
     * 
     * @param studentDto
     * @return mapped Student object
     */
    public static Student mapToStudent(StudentDto studentDto) {
        return new Student(studentDto.getId(), studentDto.getFirstName(), 
                        studentDto.getLastName(), studentDto.getEmail());
    }

}
