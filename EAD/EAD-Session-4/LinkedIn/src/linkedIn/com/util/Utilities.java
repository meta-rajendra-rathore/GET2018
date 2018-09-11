package linkedIn.com.util;

public final class Utilities {
	public final static String MYSQL_DRIVER;
	public final static String SERVER_URL;
	private final static String USER;
	private final static String PASSWORD;

	public final static String CREATE_DATABASE;
	public final static String USE_DATABASE;
	public final static String CREATE_TABLE;

	public final static String INSERT_USER;
	public final static String GET_ALL_USERMAILS;
	public final static String GET_CREDENTIAL_BY_EMAIL;
	//public final static String SHOW_ALL_USERS;
	//public final static String SEARCH_USERS;
	public final static String SEARCH_USER_WITH_EMAIL;
	public final static String UPDATE_USERS;
	public final static String UPLOAD_IMAGE;

	static {

		// MYSQL_DRIVER = "com.mysql.jdbc.Driver"; This method of connecting to
		// driver is depricated

		// Define driver, server URL and user credentials
		MYSQL_DRIVER = "com.mysql.jdbc.Driver";
		SERVER_URL = "jdbc:mysql://localhost:3306/";
		USER = "root";
		PASSWORD = "rootpassword";

		// defining MYSQL queries for execution

		CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS UserDatabase; ";
		USE_DATABASE = "USE UserDatabase; ";
		CREATE_TABLE = "CREATE TABLE IF NOT EXISTS UserTable (id INT NOT NULL AUTO_INCREMENT, "
				+ "first_name VARCHAR(15) NOT NULL, "
				+ "last_name VARCHAR(15), "
				+ "email VARCHAR(30) UNIQUE NOT NULL, "
				+ "dob DATE NOT NULL, "
				+ "password VARCHAR(20) NOT NULL, "
				+ "contact VARCHAR(15), "
				+ "organisation VARCHAR(30), "
				+ "image VARCHAR(60) DEFAULT 'images/users/user.png', "
				+ "PRIMARY KEY (id));";

		// 7 params
		INSERT_USER = "INSERT INTO UserTable ( first_name, last_name, email, dob, password, contact, organisation) VALUES ( ?, ?, ?, ?, ?, ?, ?);";

		GET_ALL_USERMAILS = "SELECT email FROM UserTable";
		
		GET_CREDENTIAL_BY_EMAIL = "SELECT password FROM UserTable WHERE email = ?";

		//SHOW_ALL_USERS = "SELECT id, first_name, last_name, email, age FROM UserTable;";

		//SEARCH_USERS = "SELECT id, first_name, last_name, email, age FROM UserTable WHERE CONCAT(first_name, ' ', LAST_name) LIKE ?; ";

		SEARCH_USER_WITH_EMAIL = "SELECT id, first_name, last_name, dob, contact, organisation, image FROM UserTable WHERE email = ?; ";

		// 6 parameters 
		UPDATE_USERS = "UPDATE UserTable SET first_name = ?, last_name = ?, dob = ?, contact = ?, organisation = ? where id = ?; ";
		
		UPLOAD_IMAGE = "UPDATE UserTable SET image = ? WHERE email = ?;";
	}

	public static String getUsername() {
		return USER;
	}

	public static String getPassword() {
		return PASSWORD;
	}

}
