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
import linkedIn.com.model.dto.FriendDto;
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
	public Status addUser(MyUser user) {
		try {
			PreparedStatement stmt = connection.prepareStatement(Utilities.INSERT_USER);
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getDob());
			stmt.setString(5, user.getPassword());
			stmt.setString(6, user.getContact());
			stmt.setString(7, user.getOrganisation());
			stmt.execute();
			return Status.OK;
		} catch (SQLIntegrityConstraintViolationException e) {
			return Status.DUPLICATE;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return Status.FAILURE;
	}

	@Override
	public Status updateUser(int id, UserDto user) {
		try {
			PreparedStatement stmt = connection.prepareStatement(Utilities.UPDATE_USERS);
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getDob());
			stmt.setString(4, user.getContact());
			stmt.setString(5, user.getOrganisation());
			stmt.setInt(6, id);
			int result = stmt.executeUpdate();
			if (result >= 0) {
				return Status.OK;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return Status.FAILURE;
	}

	@Override
	public UserDto searchUserByEmail(String email) {
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
			
			e.printStackTrace();
		}
		return Status.FAILURE;
	}

	@Override
	public List<FriendDto> getFriends(UserDto user) {
		List<FriendDto> listOfFriends = new ArrayList<FriendDto>();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(Utilities.GET_FRIENDS);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getOrganisation());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				FriendDto friend = new FriendDto(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("contact"), rs.getString("image"));
				listOfFriends.add(friend);
			}
			return listOfFriends;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
