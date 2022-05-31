package com.casmir.org.service;

import java.util.List;

import com.casmir.org.entity.Student;

public interface StudentService {
List<Student> listAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(int id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(int id);

}
