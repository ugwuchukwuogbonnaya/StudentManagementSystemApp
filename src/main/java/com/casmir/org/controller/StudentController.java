package com.casmir.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.casmir.org.entity.Student;
import com.casmir.org.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;
	   
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;	
	}
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.listAllStudents());
		
		return "students";	
		
	}
	
	//Handler method to handle list students and return model and view
	@GetMapping("/student/new")
public String createStudent(Model model) {	
		//Create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";		
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";	
	}
	
	@GetMapping("/student/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		
		model.addAttribute("student", studentService.getStudentById(id));
		
		return "edit_student";		
	}
	
	@PostMapping("/student/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student, Model model) {
		
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		studentService.updateStudent(existingStudent);
		return "redirect:/students";	
	}
	
	//Handler method to handle delete student request
		@GetMapping("/student/{id}")
		public String deleteStudent(@PathVariable int id) {
			
			studentService.deleteStudentById(id);
			
			return "redirect:/students";
			
		}
}
