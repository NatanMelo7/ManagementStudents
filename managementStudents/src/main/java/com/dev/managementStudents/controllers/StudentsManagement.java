package com.dev.managementStudents.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.managementStudents.entities.Student;
import com.dev.managementStudents.entities.User;
import com.dev.managementStudents.repositories.StudentsRepository;

@RestController
@RequestMapping(value = "/students")
@CrossOrigin
public class StudentsManagement {
	@Autowired
	private StudentsRepository studentsRepository;

	@GetMapping
	public List<Student> findAllStudents() {
		List<Student> result = studentsRepository.findAll();
		return result;
	}

	@GetMapping(value = "/{id}")
	public Student findStudentById(@PathVariable Long id) {
		Student result = studentsRepository.findById(id).get();
		return result;
	}

	@PostMapping
	public Student saveStudent(@RequestBody Student student) {
		Student result = studentsRepository.save(student);
		return result;
	}

	@PutMapping("/edit/{id}")
	public void editUser(@RequestBody Student student, @PathVariable Long id) {
		Student studentSaved = studentsRepository.findById(id).get();
		studentSaved.setMajor(student.getMajor());
		studentSaved.setName(student.getName());
		studentSaved.setReg(student.getReg());
		studentSaved.setShift(student.getShift());
		studentSaved.setStatus(student.getStatus());
		studentsRepository.save(studentSaved);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentsRepository.deleteById(id);
	}
}
