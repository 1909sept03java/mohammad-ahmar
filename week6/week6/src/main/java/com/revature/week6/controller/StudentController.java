package com.revature.week6.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.week6.model.Student;
import com.revature.week6.service.StudentService;

@RestController // @RestController = @Controller + @ResponseBody
@RequestMapping(value = "/student")
public class StudentController {
	
	private StudentService studentService;

	@Autowired // setter injection
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAll() {
		return new ResponseEntity<>(this.studentService.getAllStudents(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // parameterize the path
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		Student f = this.studentService.getStudentById(id);
		if (f == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(f, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> addStudent(@Valid @RequestBody Student student) {
		ResponseEntity<String> resp = null;
		try {
			this.studentService.addStudent(student);
			resp = new ResponseEntity<>("STUDENT CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>("FAILED TO CREATE STUDENT", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteStudent(@RequestBody Student student) {
		ResponseEntity<String> resp = null;
		try {
			this.studentService.deleteStudent(student);
			resp = new ResponseEntity<>("STUDENT DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>("FAILED TO DELETE STUDENT", HttpStatus.BAD_REQUEST);
		}
		
		return resp;
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> updateStudent(@RequestBody Student student) {
		ResponseEntity<String> resp = null;
		try {
			this.studentService.updateStudent(student);
			resp = new ResponseEntity<>("STUDENT UPDATE SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>("FAILED TO UPDATE STUDENT", HttpStatus.BAD_REQUEST);
		}
		
		return resp;
		
	}

}
