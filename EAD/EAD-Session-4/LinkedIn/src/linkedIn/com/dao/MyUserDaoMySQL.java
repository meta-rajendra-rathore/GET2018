package linkedIn.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import linkedIn.com.enums.Status;
import linkedIn.com.util.Utilities;
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

	/*@Override
	public List<MyUser> getAllEmployees() {
		try {
			PreparedStatement stmt = connection.prepareStatement(Utilities.SHOW_ALL_USERS);
			ResultSet resultSet = stmt.executeQuery();
			List<MyUser> listOfEmployees = new ArrayList<MyUser>();
			
			while (resultSet.next()) {
				//User emp = new User(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getInt("age"), null, null, null);
				//listOfEmployees.add(emp);
			}
			
			return listOfEmployees;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/

	/*@Override
	public List<MyUser> searchEmployees(String searchQuery) {
		List<MyUser> listOfEmployees = new ArrayList<MyUser>();
		try {
			PreparedStatement stmt = connection
					.prepareStatement(Utilities.SEARCH_USERS);
			stmt.setString(1, searchQuery);
			ResultSet resultSet = stmt.executeQuery();
			System.out.println(resultSet.getFetchSize()); 

			while (resultSet.next()) {
				//User emp = new User(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getInt("age"), searchQuery, searchQuery, searchQuery);
				//listOfEmployees.add(emp);
			}

			return listOfEmployees;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/

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
		} catch (SQLException e) {
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
	public MyUser searchEmployeeByID(String searchQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEmail> getAllEmails() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public User searchEmployeeByID(String searchQuery) {
		User emp = null;
		try {
			PreparedStatement stmt = connection
					.prepareStatement(Utilities.SEARCH_EMPLOYEE_WITH_ID);
			stmt.setString(1, searchQuery);
			ResultSet resultSet = stmt.executeQuery();
			System.out.println(resultSet.getFetchSize()); 
			

			while (resultSet.next()) {
				emp = new User(resultSet.getInt("id"),
						resultSet.getString("first_name"),
						resultSet.getString("last_name"),
						resultSet.getString("email"), resultSet.getInt("age"), searchQuery, searchQuery, searchQuery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Status addEmployee(User employee) {
		try {
			PreparedStatement stmt = connection.prepareStatement(Utilities.INSERT_EMPLOYEE);
			stmt.setString(1, employee.getFirstName());
			stmt.setString(2, employee.getLastName());
			stmt.setString(3, employee.getEmail());
			stmt.setInt(4, employee.getDob());
			stmt.execute();
			return Status.OK;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Status.FAILURE;
	}

	@Override
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
