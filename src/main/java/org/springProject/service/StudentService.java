package org.springProject.service;

import java.util.List;

import org.springProject.entity.Student;

public interface StudentService {
	List<Student> getAllStudent();

	void saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudentInfo(Student student);
	
	void deleteStudentById(Long id);
	
}
