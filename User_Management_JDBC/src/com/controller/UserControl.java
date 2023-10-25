package com.controller;
import java.sql.SQLException;
import java.util.*;
import com.userdao.*;
import com.user.pojo.Pojo;
import com.userdao.UserDao;
public class UserControl {
	static Scanner sc = new Scanner(System.in);

	public static void insertOption() throws ClassNotFoundException, SQLException {
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------------------");
		System.out.println("               Inserting The Record             ");
		System.out.println("------------------------------------------------");
		System.out.println();
		System.out.println("====>>  User Details : Name , Email, Contact");
		String Name = sc.next();
		String Email = sc.next();
		String Contact = sc.next();

		Pojo pj = new Pojo(Name,Email,Contact);
		boolean status = UserDao.insertUser(pj);

		if(status) {
			System.out.println("Record Successfully");
		} else {
			System.out.println("Not Inserted");
		}
	}

	public static void updateOption() throws ClassNotFoundException, SQLException {
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		System.out.println("                      Updating The Record             ");
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
		System.out.println("Enter the Id : ");
		int Id = sc.nextInt();
		System.out.println();
		System.out.println("------------------------>> Updating The Id : "+Id+" <<----------------------");
		System.out.println();
		System.out.println("Enter Name , Email , Contact to update record: ");
		String Name = sc.next();
		String Email = sc.next();
		String Contact = sc.next();
		Pojo pj = new Pojo(Id,Name,Email,Contact);
		boolean status = UserDao.updateUser(pj);

		if(status) {
			System.out.println();
			System.out.println("--------------------->> Updated Successfully <<-------------------");
			System.out.println();
		} else {
			System.out.println();
			System.out.println("------------------------->> Not Updated <<------------------------");
			System.out.println();
		}
	}

	public static void deleteOption() throws ClassNotFoundException, SQLException
	{
		System.out.println();
		System.out.println("----------------------------------------------------");
		System.out.println("                   Delete User                      ");
		System.out.println("----------------------------------------------------");
		System.out.println();
		System.out.println("Enter Id : ");
		int id = sc.nextInt();
		System.out.println();
		boolean status = UserDao.deleteUser(id);

		if(status) {
			System.out.println();
			System.out.println("------------------------>> deleted Successfully <<-------------------");
			System.out.println();
		} else {
			System.out.println();
			System.out.println("-------------------------->> Not Deleted <<--------------------------");
			System.out.println();
		}
	}
	
	public static void selectedID() throws ClassNotFoundException, SQLException {
		System.out.println();
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("                                Select By ID                         ");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println();
		System.out.println("Enter the Id: ");
		int id = sc.nextInt();
		Pojo pj = UserDao.selectByID(id);
		System.out.println();
		System.out.println("-------------------------->> ID : "+id+" <<-----------------------------");
		System.out.println();
		System.out.println("---> Name : "+pj.getName());
		System.out.println("---> Email : "+pj.getEmail());
		System.out.println("---> Contact : "+pj.getContact());
		System.out.println();
		System.out.println("------------------------------------------------------------------------");
		
	}
	
	public static void selectedAll() throws ClassNotFoundException, SQLException {
		System.out.println();
		System.out.println("----------------------------------------------------------------------");
		System.out.println("                           All User Details                       ");
		System.out.println("----------------------------------------------------------------------");
		System.out.println();
		List<Pojo> list = UserDao.selectAll();
		Iterator<Pojo> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		System.out.println("----------------------------------------------------------------------");
	}
	public static void runningProg() throws ClassNotFoundException, SQLException {

		System.out.println("----------------------------------------------------------------------");
		System.out.println("                           User Management                  ");
		System.out.println("----------------------------------------------------------------------");
		System.out.println();
		int option = 0;
		do {
			System.out.println();
			System.out.println("---------------------------->> List Of Option <<------------------");
			System.out.println();
			System.out.println("              1. Insert    ");
			System.out.println("              2. Update    ");
			System.out.println("              3. Delete    ");
			System.out.println("              4. Select By Id    ");
			System.out.println("              5. Select All User    ");
			System.out.println("              6. EXIT    ");
			System.out.println();
			System.out.println("Note : Enter 6 to Exit");
			System.out.println();
			System.out.println("------------------------------------------------------------------");
			System.out.println();
			System.out.println("Enter Option : ");
			option = sc.nextInt();
			switch(option) {
			case 1:
				// Insert The User Details
				UserControl.insertOption();
				break;

			case 2: 
				// Update the User Details
				UserControl.updateOption();
				break;

			case 3: 
				// Delete the User Details
				UserControl.deleteOption();
				break;
				
			case 4:
				// Select By ID
				UserControl.selectedID();
				break;
				
			case 5:
				// Select All
				UserControl.selectedAll();
				break;
				
			default:
				// If any option is not selected
				System.out.println();
				System.out.println("--------->> Please Select Correct Option <<-----------");
				System.out.println();
				break;
			} 
		} while (option != 6);
		System.out.println();
		System.out.println("------------------------->> Exited <<------------------------");
		System.out.println();
	}




	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Entering Point
		UserControl.runningProg();

	}
}
