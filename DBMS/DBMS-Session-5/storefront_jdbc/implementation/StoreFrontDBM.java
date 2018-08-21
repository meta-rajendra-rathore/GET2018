package storefront_jdbc.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StoreFrontDBM {
    static Connection connection;

    public static void createConnection() {
        try {
            Class.forName(UtilitiesForStore.MYSQL_DRIVER);
            String url = UtilitiesForStore.SERVER_URL;
            
            connection = DriverManager.getConnection(url,
                    UtilitiesForStore.getUsername(),
                    UtilitiesForStore.getPassword());

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
        return connection;
    }
}
