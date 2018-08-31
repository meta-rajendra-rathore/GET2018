package storefront_jdbc.databasehelper;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import storefront_jdbc.implementation.UtilitiesForStore;
import storefront_jdbc.pojos.Image;
import storefront_jdbc.pojos.Order;
import storefront_jdbc.pojos.TopCategories;

/**
 * This helper class provide executable functions on Database to StoreFrontDBM class
 * @author Rajendra Singh Rathore
 *
 */
public class DatabaseHelper {
    /**
     * This function shows the details of the order placed by the user with given ID which has the status shipped
     * The returned fields are Order ID, Order date and order amount
     * @param connection
     * @param user_ID
     */
    public static void getShippedOrdersOfUser(Connection connection, int user_ID) {
        try {
            // Prepare statement and enter remaining value of ID to be checked and execute it
            PreparedStatement stmt = connection.prepareStatement(UtilitiesForStore.SHIPPED_ORDERS_OF_USER);
            stmt.setInt(1, user_ID);
            ResultSet resultSet = stmt.executeQuery();

            // iterator through resultSet and fetch values and print
            while (resultSet.next()) {
                Order order = new Order(resultSet.getInt("ID"), resultSet.getDate("order_date"),
                        resultSet.getInt("order_amount"));
                System.out.println(order.toString());
            }

        } catch (SQLException e) {
            System.out.println("Exiting! SQL exception in the program : " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * This function insert values into Image table with attributes 
     * name, product_ID, image_URL
     * 
     * @param connection
     * @param listOfImages
     */
    public static void insertNEwImages(Connection connection, List<Image> listOfImages) {
        try {
            // Prepare statement and enter remaining value of ID to be checked and execute it
            PreparedStatement stmt = connection.prepareStatement(UtilitiesForStore.INSERT_IMAGE);
            connection.setAutoCommit(false);    // Set auto commit false to improve performance
            
            // batch insert values to insert statement 
            for (Image img : listOfImages) {
                stmt.setString(1, img.getName());
                stmt.setInt(2, img.getProduct_ID());
                stmt.setString(3, img.getImage_URL());
                stmt.addBatch();
            }

            // execute batch insert and get no of inserted rows
            int[] result = stmt.executeBatch();
            System.out.println("The number of rows inserted: " + result.length);
            connection.commit();
            
        } catch (BatchUpdateException e) {
            System.out.println("Exiting! Batch operation failed : " + e.getMessage());
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        
        catch (SQLException e) {
            System.out.println("Exiting! SQL exception : " + e.getMessage());
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * This function set those products which are not bought in last one year as disabled 
     * @param connection
     */
    public static void disableInactiveProducts(Connection connection) {
        try {
            PreparedStatement stmt = connection.prepareStatement(UtilitiesForStore.SET_DISABLE_INACTIVE_PRODUCT);
            PreparedStatement countOfInactiveProduct = connection.prepareStatement(UtilitiesForStore.COUNT_INACTIVE_PRODUCT);
            
            stmt.executeUpdate();
            
            ResultSet resultSet = countOfInactiveProduct.executeQuery();
            if (resultSet.next()) {
                System.out.println("No of items status updated to inactive : " + resultSet.getInt(1)); 
            }
        } catch (SQLException e) {
            System.out.println("Exiting! SQL exception : " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * This function shows the top categories details as their names and no of subcategories under them
     * @param connection
     */
    public static void showTopCategories(Connection connection) {
        try {
            PreparedStatement stmt = connection.prepareStatement(UtilitiesForStore.SHOW_TOP_CATEGORIES);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                TopCategories topCategory = new TopCategories(resultSet.getString("name"), resultSet.getInt("noOfSubCategories"));
                System.out.println(topCategory.toString()); 
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
