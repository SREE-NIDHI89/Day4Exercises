package com.Day4Exercises.Day4Exercise1.Service;

//import java.util.List;

import com.Day4Exercises.Day4Exercise1.Models.Student;

public interface ApiService {
 Student getStudent(int id);
 
 

int addStudent(Student student);



//List<Student> getAllStudents();



void updateStudent(Student student);



void deleteStudent(int id);
}
