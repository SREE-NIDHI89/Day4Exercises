package com.Day4Exercises.Day4Exercise1.Service;

//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Day4Exercises.Day4Exercise1.Models.Student;
import com.Day4Exercises.Day4Exercise1.Repositories.StudentRepo;

@Service
public class ApiServiceImplementation implements ApiService {
 
	
	@Autowired
	
	private StudentRepo studentRepo;
	
	@Override
	 public Student getStudent(int id) {
		Optional<Student> optional=studentRepo.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	@Override
	
	public int addStudent(Student student) {
		Student save=studentRepo.save(student);
		return save.getId();
		}
	
//	@Override
//	
//	public List<Student> getAllStudents(){
//		return studentRepo.findAll();
//	}
	
	@Override
	public void updateStudent(Student student) {
		studentRepo.save(student);
		
	}
	
	@Override
	public void deleteStudent(int id) {
		Optional<Student> optional = studentRepo.findById(id);
		if(!optional.isEmpty()) {
			studentRepo.delete(optional.get());
		}
	}
	
}
