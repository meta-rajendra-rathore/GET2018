package linkedIn.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import linkedIn.com.model.dto.UserEmail;
import linkedIn.com.util.Utilities;

public class EmailDaoMySQL {
	private static EmailDaoMySQL userEmailDao = new EmailDaoMySQL();
	private static Connection connection;
	
	private EmailDaoMySQL() {
		createConnection();
		DatabaseHelper.createDatabase(connection);
	}
	
	public void createConnection() {
		connection = ConnectionFactory.getConnection();
	}
	
	public static EmailDaoMySQL getInstance() {
		return userEmailDao;
	}

	public List<UserEmail> getAllEmails() {
		try {
			PreparedStatement stmt = connection.prepareStatement(Utilities.GET_ALL_USERMAILS);
			ResultSet rs = stmt.executeQuery();
			List<UserEmail> listOfEmails = new ArrayList<UserEmail>();
			while (rs.next()) {
				UserEmail email = new UserEmail(rs.getString("email"));
				listOfEmails.add(email);
			}
			return listOfEmails;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
