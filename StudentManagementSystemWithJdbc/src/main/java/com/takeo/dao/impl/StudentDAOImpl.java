package com.takeo.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.takeo.configure.JdbcUtility;
import com.takeo.dao.StudentDAO;
import com.takeo.model.Student;
import com.takeo.query.QueryConstants;

public class StudentDAOImpl implements StudentDAO {
	
	Scanner sc=new Scanner(System.in);
	
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;

	public void register() {
		// TODO Auto-generated method stub
		
		
		//to store the data into the database, we need to have connection
		int k=1;
		while(k==1)
		{
		
		try {
			con=JdbcUtility.getConnection();
			
			//Prepared Statements
			ps=con.prepareStatement(QueryConstants.STUDENT_INSERT_QUERY);
			
			
			//set values for column
			System.out.println("Enter Student First Name");
			String fname=sc.next();
			System.out.println("Enter Student Last Name");
			String lname=sc.next();
			System.out.println("Enter Student Address");
			String sadd=sc.next();
			System.out.println("Enter Student Email");
			String email=sc.next();
			
			//set the values for each column into data base with insert query
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, sadd);
			ps.setString(4, email);
			
			int count = ps.executeUpdate();
			
			if(count !=0)
				System.out.println("User Registration Has Been Completed Successfully");
			else
				System.out.println("User Registration Was Unsuccessful");
			
			System.out.println("Do you want to Add new Student? 1) Yes 2) No ");
			
			k=sc.nextInt();
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
		
		try {
			JdbcUtility.closeConnection(con, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		}   //end of while
		
		
		
	}

	public List<Student> viewAllStudents() {
		// TODO Auto-generated method stub
		List<Student> addStudents=new ArrayList<Student>();
		
		try {
			con=JdbcUtility.getConnection();
			
			
			ps=con.prepareStatement(QueryConstants.STUDENT_SELECT_QUERY);
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				int sid=rs.getInt(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				String sadd=rs.getString(4);
				String email=rs.getString(5);
				
				Student student=new Student(sid,fname,lname,sadd,email);
				
				addStudents.add(student);
				
				
			}  //end of while loop
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
		
		try {
			JdbcUtility.closeConnection(con, ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		return addStudents;
	}

	public Student viewStudent(int sid) {
		// TODO Auto-generated method stub
		Student viewStu=null;
		
		try {
			con=JdbcUtility.getConnection();
			
			ps=con.prepareStatement(QueryConstants.STUDENT_VIEWSPECIFIC_QUERY);
			
			ps.setInt(1, sid);
			
		rs=ps.executeQuery();
		
			//set student ID to retrieve data
		while(rs.next())
		{
			int id=rs.getInt(1);
			String fname1=rs.getString(2);
			String lname1=rs.getString(3);
			String add=rs.getString(4);
			String mail=rs.getString(5);
			
		 viewStu=new Student(id,fname1,lname1,add,mail);
			
	/*		viewStudent.add(viewStu);
			
			for(Student stu: viewStudent)
			{
				if(stu.getSid()==sid)
					return stu;
				//System.out.println(stu.getSid()+"\t"+stu.getFirstName()+"\t"+stu.getLastName()+"\t"+stu.getsAddress()+"\t"+stu.getEmail());
				else
					System.out.println("The ID Doesn't Exist");
			}
			*/
			return viewStu;
		}
			
			
		/*	
			for(Student stu: viewStudent)
			{
				if(stu.getSid()==sid)
				{
					return stu;
				}
					
			}
			
		*/	
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				JdbcUtility.closeConnection(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	return null;	
		
		
		
	}

	public int updateStudent(int sid) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			con=JdbcUtility.getConnection();
			
			ps=con.prepareStatement(QueryConstants.STUDENT_UPDATE_QUERY);
			
			//setting value for update
			
			
			
			
			//setting new values for column now
			System.out.println("Enter New First Name Of Student");
			String fname=sc.next();
			System.out.println("Enter New Last Name of Student");
			String lname=sc.next();
			System.out.println("Enter New Address for Student");
			String sadd=sc.next();
			System.out.println("Enter New Email for Student");
			String email=sc.next();
			
			
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, sadd);
			ps.setString(4, email);
			ps.setInt(5, sid);
			
			
			//setting values
			 count=ps.executeUpdate();
			
			if(count !=0)
				System.out.println("Updated Successfully");
			else
				System.out.println("Not Updated");
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				JdbcUtility.closeConnection(con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		return count;
	}

	public int deleteStudent(int sid) {
		// TODO Auto-generated method stub
		
		int count=0;
		try {
			con=JdbcUtility.getConnection();
			
			ps=con.prepareStatement(QueryConstants.STUDENT_DELETE_QUERY);
			
			//System.out.println("Enter Student ID to delete");
			//int id=sc.nextInt();
			
			ps.setInt(1, sid);
			
		 count=ps.executeUpdate();
			
			if(count !=0)
				System.out.println("The Student Info Has Been Deleted");
			else
				System.out.println("The Deletion Was Unsuccessful");
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				JdbcUtility.closeConnection(con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return count;
	}

}
