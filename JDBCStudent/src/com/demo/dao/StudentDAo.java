package com.demo.dao;

import java.util.List;

import com.demo.beans.Student;

public interface StudentDAo {

	boolean addStudent(int id, String name, String add, String dob);

	boolean updateStudent(int rollno, int newRoll, String name, String add, String dob);

	List<Student> show();

}
