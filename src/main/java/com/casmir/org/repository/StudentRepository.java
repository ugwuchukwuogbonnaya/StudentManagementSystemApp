package com.casmir.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casmir.org.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
