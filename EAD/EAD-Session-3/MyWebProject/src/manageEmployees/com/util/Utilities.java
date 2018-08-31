package manageEmployees.com.util;

public final class Utilities {
	public final static String MYSQL_DRIVER;
    public final static String SERVER_URL;
    private final static String USER;
    private final static String PASSWORD;

    public final static String CREATE_DATABASE;
    public final static String USE_DATABASE;
    public final static String CREATE_TABLE;
    public final static String INSERT_EMPLOYEE;
    public final static String SHOW_ALL_EMPLOYEES;
    public final static String SEARCH_EMPLOYEES;
    public final static String SEARCH_EMPLOYEE_WITH_ID;
    public final static String UPDATE_EMPLOYEES;

    static {
    	
        //MYSQL_DRIVER = "com.mysql.jdbc.Driver";   This method of connecting to driver is depricated
        
        // Define driver, server URL and user credentials 
        MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
        SERVER_URL = "jdbc:mysql://localhost:3306/storefront";
        USER = "root";
        PASSWORD = "rootpassword";

        // defining MYSQL queries for execution 
        
        CREATE_DATABASE =  "CREATE DATABASE IF NOT EXISTS EmployeeDatabase; ";
        USE_DATABASE =  "USE EmployeeDatabase; ";
        CREATE_TABLE =  "CREATE TABLE IF NOT EXISTS Employee ( " + 
						"    id INT NOT NULL AUTO_INCREMENT, " + 
						"    first_name VARCHAR(15) NOT NULL, " + 
						"    last_name VARCHAR(15), " + 
						"    email VARCHAR(30) UNIQUE NOT NULL, " + 
						"    age INT NOT NULL, " + 
						"    PRIMARY KEY(id) );" ;

        INSERT_EMPLOYEE = "INSERT INTO employee ( first_name, last_name, email, age) VALUES ( ?,?,?,? )";

        SHOW_ALL_EMPLOYEES =  "SELECT id, first_name, last_name, email, age FROM employee;";

        SEARCH_EMPLOYEES =   "SELECT id, first_name, last_name, email, age FROM employee WHERE CONCAT(first_name, ' ', LAST_name) LIKE ?; ";

        SEARCH_EMPLOYEE_WITH_ID =   "SELECT id, first_name, last_name, email, age FROM employee WHERE id = ?; ";

        UPDATE_EMPLOYEES =   "UPDATE Employee SET first_name = ?, last_name = ?, email = ?, age = ? where id = ?; ";
    }

    public static String getUsername() {
        return USER;
    }

    public static String getPassword() {
        return PASSWORD;
    }

}
