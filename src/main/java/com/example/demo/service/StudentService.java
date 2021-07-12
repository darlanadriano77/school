package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;



@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> findAll(){
		
		return studentRepository.findAll();
	}
	
	public Student findById(Long id) {
		return studentRepository.findById(id).get();
	}
	
	public Student save(Student student) {
		return studentRepository.save(student);
	}
	
	
	public void delete(Long id) {
		Student student = new Student();
		student.setId(id);
		studentRepository.delete(student);
	}
	public Student update(Student student,Long id) {
		Student studentFiound = findById(id);
		if(studentFiound == null) {
			throw new EmptyResultDataAccessException(1);
		}
		student.setId(id);
		return studentRepository.save(student);
	}
}
