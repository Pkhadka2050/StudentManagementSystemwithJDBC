package com.takro.client;

import java.util.Scanner;

import com.takeo.dao.impl.details.StudentDetails;

public class StudentClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudentDetails details=new StudentDetails();
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("===================================================");
			System.out.println("                           1) Student     ");
			System.out.println("                           2) Exit         ");
			
			
			System.out.println("===================================================");
			
			System.out.println("Enter Your Choice");
			int choice =sc.nextInt();
			
			switch(choice)
			{
			case 1:
				details.studentMenu();
				break;
				
			case 2:
				System.out.println("Thank you For Visiting Us");
				System.exit(0);
				break;
				default:
					System.out.println("Choose Between 1 and 2");
			}   //end of switch
		}  //end of while

	}

}
