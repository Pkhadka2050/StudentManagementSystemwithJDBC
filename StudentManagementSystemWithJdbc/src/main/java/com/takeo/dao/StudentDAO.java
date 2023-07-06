package com.takeo.dao;

import java.util.ArrayList;
import java.util.List;

import com.takeo.model.Student;

public interface StudentDAO {
	
	public void register();
	
	List<Student> viewAllStudents();
	
	public Student viewStudent(int sid);
	public int updateStudent(int sid);
	public int deleteStudent(int sid);
	
}
