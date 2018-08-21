package storefront_jdbc.implementation;

/**
 * The class consists of all the utilities for the storefront. It contains all
 * the queries and Variable names including user credentials and server information 
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
    public final static String COUNT_INACTIVE_PRODUCT;

    static {
        //MYSQL_DRIVER = "com.mysql.jdbc.Driver";   This method of connecting to driver is depricated
        
        // Define driver, server URL and user credentials 
        MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
        SERVER_URL = "jdbc:mysql://localhost:3306/storefront";
        USER = "root";
        PASSWORD = "0000";

        // defining MYSQL queries for execution 
        SHIPPED_ORDERS_OF_USER = "SELECT Product.ID, Orders.order_date, Orders.order_amount " + "FROM Product "
                + "INNER JOIN Products_In_order ON product.ID = product_ID "
                + "INNER JOIN Orders ON order_ID = orders.ID " + "WHERE order_status = \"shipped\" AND user_ID = ? "
                + "ORDER BY order_date;";

        INSERT_IMAGE = "INSERT INTO Image ( name, product_ID, image_URL ) VALUES ( ?,?,? )";

        SET_DISABLE_INACTIVE_PRODUCT =  "UPDATE Product SET is_enable = 0 " + 
                                        "WHERE ID NOT IN  (  " + 
                                        "    SELECT product_ID " + 
                                        "    from Products_In_Order " + 
                                        "    LEFT JOIN Orders ON order_ID = ID " + 
                                        "    WHERE order_date >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)); ";

        /*COUNT_INACTIVE_PRODUCT =  "SELECT COUNT(ID) FROM Product " + 
                                        "WHERE ID NOT IN  (  " + 
                                        "    SELECT product_ID " + 
                                        "    from Products_In_Order " + 
                                        "    LEFT JOIN Orders ON order_ID = ID " + 
                                        "    WHERE order_date >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)) AND is_enable = 0; ";*/
        COUNT_INACTIVE_PRODUCT =   "SELECT COUNT(ID) FROM Product " + 
                                    "WHERE is_enable = 0; ";
        
        SHOW_TOP_CATEGORIES = "SELECT parent.Name, COUNT(parent.ID) AS noOfSubCategories \r\n" + 
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
