package storefront_jdbc.implementation;

/**
 * The class consists of all the utilities for the storefront It contains all
 * the queries and Variable names
 * 
 * @author Rajendra Singh Rathore
 *
 */
public class UtilitiesForStore {
    public final static String MYSQL_DRIVER;
    public final static String SERVER_URL;
    private final static String USER;
    private final static String PASSWORD;

    public final static String SHIPPED_ORDERS_OF_USER;
    public final static String INSERT_IMAGE;
    public final static String SET_DISABLE_INACTIVE_PRODUCT;
    public final static String SHOW_TOP_CATEGORIES;

    static {
        MYSQL_DRIVER = "com.mysql.jdbc.Driver";
        //MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
        SERVER_URL = "jdbc:mysql://localhost:3306/storefront";
        USER = "root";
        PASSWORD = "rootpassword";

        SHIPPED_ORDERS_OF_USER = "SELECT Product.ID, Orders.order_date, Orders.order_amount " + "FROM Product "
                + "INNER JOIN Products_In_order ON product.ID = product_ID "
                + "INNER JOIN Orders ON order_ID = orders.ID " + "WHERE order_status = \"shipped\" AND user_ID = ?"
                + "ORDER BY order_date;";

        INSERT_IMAGE = "INSERT INTO Image ( name, product_ID, image_URL ) VALUES ( ?,?,? );";

        SET_DISABLE_INACTIVE_PRODUCT =  "SET SQL_SAFE_UPDATES  = 0;\r\n" + 
                                        "UPDATE Product SET is_enable = 0 \r\n" + 
                                        "WHERE ID NOT IN  ( \r\n" + 
                                        "    SELECT product_ID \r\n" + 
                                        "    from Products_In_Order \r\n" + 
                                        "    LEFT JOIN Orders ON order_ID = ID \r\n" + 
                                        "    WHERE order_date >= CURDATE() - 365);\r\n" + 
                                        "SET SQL_SAFE_UPDATES  = 1;";
        
        SHOW_TOP_CATEGORIES = "SELECT parent.Name, COUNT(parent.ID) \r\n" + 
                            "FROM Category parent LEFT JOIN Category child ON parent.ID = child.parent_category_ID\r\n" + 
                            "WHERE parent.parent_category_ID IS NULL \r\n" + 
                            "GROUP BY child.parent_category_ID;";
    }

    public static String getUsername() {
        return USER;
    }

    public static String getPassword() {
        return PASSWORD;
    }
}
