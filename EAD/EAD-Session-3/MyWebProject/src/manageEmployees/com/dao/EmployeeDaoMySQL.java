package manageEmployees.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageEmployees.com.enums.Status;
import manageEmployees.com.model.pojo.Employee;
import manageEmployees.com.util.Utilities;

public class EmployeeDaoMySQL implements EmployeeDao {
	private static EmployeeDaoMySQL empDao = new EmployeeDaoMySQL();
	private static Connection connection;
	
	private EmployeeDaoMySQL() {
		createConnection();
		DatabaseHelper.createDatabase(connection);
	}
	
	private void createConnection() {
		connection = ConnectionFactory.getConnection();
	}
	
	public static EmployeeDaoMySQL getInstance() {
		return empDao;
	}

	@Override
	public List<Employee> getAllEmployees() {
		try {
			PreparedStatement stmt = connection.prepareStatement(Utilities.SHOW_ALL_EMPLOYEES);
			ResultSet resultSet = stmt.executeQuery();
			List<Employee> listOfEmployees = new ArrayList<Employee>();
			
			while (resultSet.next()) {
				Employee emp = new Employee(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getInt("age"));
				listOfEmployees.add(emp);
			}
			
			return listOfEmployees;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> searchEmployees(String searchQuery) {
		List<Employee> listOfEmployees = new ArrayList<Employee>();
		try {
			PreparedStatement stmt = connection
					.prepareStatement(Utilities.SEARCH_EMPLOYEES);
			stmt.setString(1, searchQuery);
			ResultSet resultSet = stmt.executeQuery();
			System.out.println(resultSet.getFetchSize()); 

			while (resultSet.next()) {
				Employee emp = new Employee(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getInt("age"));
				listOfEmployees.add(emp);
			}

			return listOfEmployees;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee searchEmployeeByID(String searchQuery) {
		Employee emp = null;
		try {
			PreparedStatement stmt = connection
					.prepareStatement(Utilities.SEARCH_EMPLOYEE_WITH_ID);
			stmt.setString(1, searchQuery);
			ResultSet resultSet = stmt.executeQuery();
			System.out.println(resultSet.getFetchSize()); 
			

			while (resultSet.next()) {
				emp = new Employee(resultSet.getInt("id"),
						resultSet.getString("first_name"),
						resultSet.getString("last_name"),
						resultSet.getString("email"), resultSet.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Status addEmployee(Employee employee) {
		try {
			PreparedStatement stmt = connection.prepareStatement(Utilities.INSERT_EMPLOYEE);
			stmt.setString(1, employee.getFirstName());
			stmt.setString(2, employee.getLastName());
			stmt.setString(3, employee.getEmail());
			stmt.setInt(4, employee.getAge());
			stmt.execute();
			return Status.OK;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Status.FAILURE;
	}

	@Override
	public Status updateEmployee(int id, Employee employee) {
		try {
			PreparedStatement stmt = connection.prepareStatement(Utilities.UPDATE_EMPLOYEES);
			stmt.setString(1, employee.getFirstName());
			stmt.setString(2, employee.getLastName());
			stmt.setString(3, employee.getEmail());
			stmt.setInt(4, employee.getAge());
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
	}

}
