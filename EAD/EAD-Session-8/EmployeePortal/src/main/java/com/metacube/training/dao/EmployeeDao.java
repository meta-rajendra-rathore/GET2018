/**
 * 
 */
package com.metacube.training.dao;

/**
 * @author Rajendra Singh Rathore
 *
 */
public class EmployeeDao {
	public static final String CREATE_EMPLOYEE_TABLE;
	public static final String INSERT_EMPLOYEE;
	public static final String EDIT_EMPLOYEE;/*
	public static final String CREATE_SKILLS;
	public static final String CREATE_SKILLS_MASTER;
	public static final String CREATE_PROJECT_MASTER;*/

	static {
		CREATE_EMPLOYEE_TABLE = "create table employees( "
				+ "emp_code INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
				+ "first_name VARCHAR(100) NOT NULL, "
				+ "last_name VARCHAR(100), "
				+ "dob DATE NOT NULL, "
				+ "gender VARCHAR(1) NOT NULL, "
				+ "primary_contact_number VARCHAR(10), "
				+ "secondary_contact_number VARCHAR(10), "
				+ "email_id VARCHAR(100) NOT NULL UNIQUE, "
				+ "skype_id VARCHAR(100), "
				+ "profile_picture VARCHAR(512), "
				+ "password VARCHAR(100) NOT NULL, "
				+ "enabled BOOLEAN DEFAULT true );";
		
		INSERT_EMPLOYEE = "INSERT INTO EMPLOYEE "
				+ "(emp_code, first_name, last_name, dob, gender, primary_contact_number, secondary_contact_number, email_id, skype_id, profile_picture, password, enabled) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		EDIT_EMPLOYEE = "UPDATE EMPLOYEE SET first_name = ?, last_name = ?, dob = ?, gender = ?, primary_contact_number = ?, secondary_contact_number = ?, email_id = ?, skype_id = ?, profile_picture = ?, enabled = ?;";
		
		
	}
}
