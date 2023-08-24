package com.Day4Exercises.Day4Exercise1.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.Day4Exercises.Day4Exercise1.Models.Student;
import com.Day4Exercises.Day4Exercise1.Service.ApiService;

//@RequestMapping("/")
@RestController
public class ApiController {

	
	@Autowired
	private ApiService apiService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id) {
		Student student = apiService.getStudent(id);
		if (student == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	
	@PostMapping("/student")
	public ResponseEntity<Integer> addStudent(@RequestBody Student student) {
		int id = apiService.addStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(id);
	}
	
	@PutMapping("/student")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		apiService.updateStudent(student);
		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping("/student")
	public ResponseEntity<String> deleteStudent(@RequestBody Student student) {
		apiService.deleteStudent(student.getId());
		return ResponseEntity.ok("Deleted");
	}

	
}
