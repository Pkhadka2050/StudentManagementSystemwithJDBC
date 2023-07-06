package com.takeo.dao.impl.details;

import java.util.List;
import java.util.Scanner;

import com.takeo.dao.impl.StudentDAOImpl;
import com.takeo.model.Student;
import com.takro.client.StudentClient;

public class StudentDetails {
	
	Scanner sc=new Scanner(System.in);
	
	StudentDAOImpl daoImpl=new StudentDAOImpl();
	
	public void studentMenu()
	{
		while(true)
		{
		System.out.println("========================================================");
		System.out.println("            1) AddStudents             ");
		System.out.println("            2) View All Students        ");
		System.out.println("            3) View Specific Student    ");
		System.out.println("            4) Update Student Info      ");
		System.out.println("            5) Delete Student Info       ");
		System.out.println("            6) Back                      ");
		
		System.out.println("=========================================================");
		
		System.out.println("Enter Your Choice");
		int choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:
			daoImpl.register();
			break;
			
		case 2:
			List<Student> viewallstudents=daoImpl.viewAllStudents();
			for(Student stu: viewallstudents)
			{
				System.out.println(stu.getSid()+"\t"+stu.getFirstName()+"\t"+stu.getLastName()+"\t"+stu.getsAddress()+"\t"+stu.getEmail());
				
			}
			
			break;
			
		case 3:
			
			
			System.out.println("Enter Student ID");
			int sid=sc.nextInt();
			Student viewSpecificStudent=daoImpl.viewStudent(sid);
			
			if(viewSpecificStudent !=null)
			System.out.println(viewSpecificStudent.getSid()+"\t"+viewSpecificStudent.getFirstName()+"\t"+viewSpecificStudent.getLastName()+"\t"+viewSpecificStudent.getsAddress()+"\t"+viewSpecificStudent.getEmail());
			
				
			
			break;
			
		case 4:
			System.out.println("Enter Student ID to Update");
			int id=sc.nextInt();
			int update=daoImpl.updateStudent(id);
			
			break;
			
		case 5:
			System.out.println("Enter Student ID");
			int sid1=sc.nextInt();
			int delete=daoImpl.deleteStudent(sid1);
			break;
			
		case 6:
			StudentClient.main(null);
			break;
			default:
				System.out.println("Choose between 1 to 6");
		}  // end of switch
		} ///end of while loop
	}

}
