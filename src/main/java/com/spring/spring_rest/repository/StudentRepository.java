package com.spring.spring_rest.repository;

import com.spring.spring_rest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * StudentRepository
 * 
 * Extends JpaRepository, an interface provided by the Spring Data JPA library
 * that handles all database operations.
 * Spring automatically generates the implementation code at runtime.
 * 
 * @author Felisa Bascug
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

}
