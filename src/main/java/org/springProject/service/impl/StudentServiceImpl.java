package org.springProject.service.impl;

import java.util.List;

import org.springProject.entity.Student;
import org.springProject.repository.StudentRepository;
import org.springProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

}
