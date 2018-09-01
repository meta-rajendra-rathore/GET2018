package linkedIn.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import linkedIn.com.model.dto.UserCredentials;
import linkedIn.com.util.Utilities;

public class CredentialsDaoMySQL {
	private static CredentialsDaoMySQL userPasswordDao = new CredentialsDaoMySQL();
	private static Connection connection;
	
	private CredentialsDaoMySQL() {
		createConnection();
		DatabaseHelper.createDatabase(connection);
	}
	
	public void createConnection() {
		connection = ConnectionFactory.getConnection();
	}
	
	public static CredentialsDaoMySQL getInstance() {
		return userPasswordDao;
	}
	
	public UserCredentials getCredentialsByEmail(String email) {
		try {
			PreparedStatement stmt = connection.prepareStatement(Utilities.GET_CREDENTIAL_BY_EMAIL);
			stmt.setString(1, email); 
			ResultSet result = stmt.executeQuery(); 
			while (result.next()) {
				return new UserCredentials(result.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
}
