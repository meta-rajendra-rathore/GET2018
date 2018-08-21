package storefront_jdbc.implementation;

/**
 * This is the main class which contain the connection to the server and 
 * also consist of main working functions calling in void main
 * @author Rajendra Singh Rathore
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import storefront_jdbc.databasehelper.DatabaseHelper;
import storefront_jdbc.pojos.Image;

public class StoreFrontDBM {
    static Connection connection;

    /**
     * Create new connection to the server using user credentials and server port url address
     */
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
    
    /**
     * Void main function calling all the main defined functions
     * @param args
     */
    public static void main(String[] args) {
        StoreFrontDBM.createConnection();
        Connection connection = StoreFrontDBM.getConnection();
        
        DatabaseHelper.getShippedOrdersOfUser(connection, 2);
        
        /**
         * adding new images to image list to be added to the Image table
         */
        List<Image> listOfImages = new ArrayList<>();
        listOfImages.add(new Image(5, "Front", "www.mystorage.come/project1/product5/Front"));
        listOfImages.add(new Image(5, "Side1", "www.mystorage.come/project1/product5/Side1"));
        listOfImages.add(new Image(5, "Side2", "www.mystorage.come/project1/product5/Side2"));
        listOfImages.add(new Image(5, "Behind", "www.mystorage.come/project1/product5/Behind"));
        DatabaseHelper.insertNEwImages(connection, listOfImages);
        
        DatabaseHelper.disableInactiveProducts(connection);
        
        DatabaseHelper.showTopCategories(connection);
    }
}
