package org.springProject.controller;

import org.springProject.entity.Student;
import org.springProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	// Get all the students handler
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudent());
		return "students";
	}

	// get new student info Handler
	@GetMapping("/students/new")
	public String createStudent(Model model) {
		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);

		return "createStudent";
	}

	// Add new student to DB Handler
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	// edit student handler
	@GetMapping("/students/edit/{id}")
	public String editStudentInfo(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "editStudentInfo";
	}

	// update student info in DB handler
	@PostMapping("/students/{id}")
	public String updateStudentInfo(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		//get student from DB from id
		Student existingStudent = studentService.getStudentById(id);
		
		// update student info
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		// save updated student info to db
		studentService.updateStudentInfo(existingStudent);
		
		return "redirect:/students";
	}
	
	//Delete student handler
	@GetMapping("/students/remove/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}

}
