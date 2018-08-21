package storefront_jdbc.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import storefront_jdbc.pojos.Order;

/**
 * 
 * @author Rajendra Singh Rathore
 *
 */
public class DatabaseHelper {
    public static void getShippedOrdersOfUser(Connection connection, int user_ID) {
        try {
            PreparedStatement stmt = connection.prepareStatement(UtilitiesForStore.SHIPPED_ORDERS_OF_USER);
            stmt.setInt(1, user_ID); 
            ResultSet resultSet = stmt.executeQuery();
            
            while (resultSet.next()) {
                Order order = new Order(resultSet.getInt(1), resultSet.getDate(2), resultSet.getInt(3));
                System.out.println(order.toString());
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
