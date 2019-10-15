package com.revature.week6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.week6.model.Student;
import com.revature.week6.repository.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getAllStudents() {
		return this.studentRepository.findAll();
	}

	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return this.studentRepository.findById(id).orElse(null);
	}
	
	public void addStudent(Student f) {
		this.studentRepository.save(f);
	}

	public void deleteStudent(Student s) {
		this.studentRepository.delete(s);
	}

	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		this.studentRepository.save(student);
		
	}


}
