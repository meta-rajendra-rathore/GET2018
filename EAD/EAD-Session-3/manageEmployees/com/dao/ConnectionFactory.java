package manageEmployees.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import manageEmployees.com.util.Utilities;

public class ConnectionFactory {
	private static Connection connection;

    /**
     * Create new connection to the server using user credentials and server port url address
     */
    static {
        try {
            Class.forName(Utilities.MYSQL_DRIVER);
            String url = Utilities.SERVER_URL;
            
            connection = DriverManager.getConnection(url,
                    Utilities.getUsername(),
                    Utilities.getPassword());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Class not found : " + e.getMessage());
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL exception : " + e.getMessage());
            System.exit(2);
        }
    }

    /**
     * @return the connection
     */
    public static Connection getConnection() {
        if (connection == null) {
            System.out.println("SQL exception : No connection could be established!");
            System.exit(2);
        }
		return connection;
    }
}
