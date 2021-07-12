package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/Students")
public class StudentsController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public List<Student> getStudnts() {
		return studentService.findAll();
	}
	
	@GetMapping("/{id}")
	public Student findById(@PathVariable Long id) {
		return studentService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Student> save(@Valid @RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student));
		}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		studentService.delete(id);
	}
	
	@PutMapping("/{id}")
	public Student update(@Valid @RequestBody Student student, @PathVariable Long id) {
		return studentService.update(student, id);
	}
	}
