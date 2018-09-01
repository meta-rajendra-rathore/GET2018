package linkedIn.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import linkedIn.com.enums.Status;
import linkedIn.com.util.Utilities;
import linkedIn.com.model.dto.UserDto;
import linkedIn.com.model.dto.UserEmail;
import linkedIn.com.model.pojo.MyUser;

public class MyUserDaoMySQL implements MyUserDao {
	private static MyUserDaoMySQL empDao = new MyUserDaoMySQL();
	private static Connection connection;
	
	private MyUserDaoMySQL() {
		createConnection();
		DatabaseHelper.createDatabase(connection);
	}
	
	public void createConnection() {
		connection = ConnectionFactory.getConnection();
	}
	
	public static MyUserDaoMySQL getInstance() {
		return empDao;
	}

	@Override
	public Status addEmployee(MyUser employee) {
		try {
			PreparedStatement stmt = connection.prepareStatement(Utilities.INSERT_USER);
			stmt.setString(1, employee.getFirstName());
			stmt.setString(2, employee.getLastName());
			stmt.setString(3, employee.getEmail());
			stmt.setString(4, employee.getDob());
			stmt.setString(5, employee.getPassword());
			stmt.setString(6, employee.getContact());
			stmt.setString(7, employee.getOrganisation());
			stmt.execute();
			return Status.OK;
		} catch (SQLIntegrityConstraintViolationException e) {
			return Status.DUPLICATE;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Status.FAILURE;
	}

	@Override
	public Status updateEmployee(int id, MyUser employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto searchEmployeeByEmail(String email) {
		System.out.println("here : " + email); 
		UserDto user = null;
		try {
			PreparedStatement stmt = connection
					.prepareStatement(Utilities.SEARCH_USER_WITH_EMAIL);
			stmt.setString(1, email);
			ResultSet resultSet = stmt.executeQuery();
			System.out.println(resultSet.getFetchSize()); 
			

			while (resultSet.next()) {
				user = new UserDto(resultSet.getInt("id"),
						resultSet.getString("first_name"),
						resultSet.getString("last_name"),
						email, resultSet.getString("dob"), resultSet.getString("contact"), resultSet.getString("organisation"), resultSet.getString("image"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Status uploadImage(String imageURL, String email) {
		try {
			PreparedStatement stmt = connection.prepareStatement(Utilities.UPLOAD_IMAGE);
			stmt.setString(1, imageURL); 
			stmt.setString(2, email); 
			int result = stmt.executeUpdate();
			if (result >= 0) {
				return Status.OK;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Status.FAILURE;
	}

	/*@Override
	public Status updateEmployee(int id, User employee) {
		try {
			PreparedStatement stmt = connection.prepareStatement(Utilities.UPDATE_EMPLOYEES);
			stmt.setString(1, employee.getFirstName());
			stmt.setString(2, employee.getLastName());
			stmt.setString(3, employee.getEmail());
			stmt.setInt(4, employee.getDob());
			stmt.setInt(5, id);
			int result = stmt.executeUpdate();
			if (result >= 0) {
				return Status.OK;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Status.FAILURE;
	}*/

}
