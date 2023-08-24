package com.Day4Exercises.Day4Exercise1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Day4Exercises.Day4Exercise1.Models.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{

}
