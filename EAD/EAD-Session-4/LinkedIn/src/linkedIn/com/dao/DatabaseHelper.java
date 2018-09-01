package linkedIn.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import linkedIn.com.enums.Status;
import linkedIn.com.util.Utilities;

public class DatabaseHelper {
	public static Status createDatabase(Connection connection) {
		try {
			PreparedStatement stmt;
			stmt = connection.prepareStatement(Utilities.CREATE_DATABASE);
			stmt.executeUpdate();
			stmt = connection.prepareStatement(Utilities.USE_DATABASE);
			stmt.executeUpdate();
			stmt = connection.prepareStatement(Utilities.CREATE_TABLE);
			stmt.executeUpdate();
			return Status.OK;
		} catch (SQLException e) {
			e.printStackTrace();
			return Status.FAILURE;
		}
	}
}
