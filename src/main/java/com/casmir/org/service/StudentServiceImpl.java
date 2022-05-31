package com.casmir.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casmir.org.entity.Student;
import com.casmir.org.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {
	
	
  private StudentRepository  studentRepository;
	
	@Autowired
   public StudentServiceImpl(StudentRepository studentRepository) {
			this.studentRepository = studentRepository;
		}


	@Override
	public List<Student> listAllStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(int id) {
		
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(int id) {
		studentRepository.deleteById(id);

	}

}
