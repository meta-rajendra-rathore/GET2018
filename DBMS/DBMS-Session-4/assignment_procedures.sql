/* 1. 
Create a Stored procedure to retrieve average sales of each product in a month. 
Month and year will be input parameter to function. */

USE storefront;

DROP PROCEDURE IF EXISTS avg_sales_in_month;

DELIMITER $$
CREATE PROCEDURE avg_sales_in_month (
    IN query_month INT,
    IN query_year INT )
BEGIN
    SELECT 
        product_ID AS ID, 
        product.Title, 
        TRUNCATE(SUM(product_quantity)/COUNT(product_ID), 2) AS 'Average Sales' 
    FROM Products_In_Order 
    LEFT JOIN
    Product
    ON ID = product_ID
    GROUP BY PRODUCT_ID;
END $$

CALL avg_sales_in_month(8, 2018);
    
/* 2.
Create a stored procedure to retrieve table having order detail with status for a given period. 
Start date and end date will be input parameter. Put validation on input dates like start date is less than end date. 
If start date is greater than end date take first date of month as start date. */

DROP PROCEDURE IF EXISTS order_details_in_period;

DELIMITER ^^
CREATE PROCEDURE order_details_in_period (
    IN start_date DATE,
    IN end_date DATE )
BEGIN
    SELECT 
        Orders.ID AS 'Order ID',
        Product.ID AS 'Product ID',
        Product.title AS 'Product Name',
        Orders.order_date AS 'Order date',
        Products_In_Order.order_status AS 'Order status'
    FROM Orders
    RIGHT JOIN
    Products_In_Order
    ON Orders.ID = Products_In_Order.order_ID
    LEFT JOIN
    Product
    ON Products_In_Order.product_ID = Product.ID
    WHERE order_date 
        BETWEEN IF(start_date >= end_date, DATE_FORMAT(end_date, "%Y-%m-01"), start_date) 
        AND end_date
    ORDER BY order_date;
END ^^

CALL order_details_in_period( STR_TO_DATE("2018-08-05", "%Y-%m-%d"),STR_TO_DATE("2018-08-10", "%Y-%m-%d") );

CALL order_details_in_period( STR_TO_DATE("2018-08-15", "%Y-%m-%d"),STR_TO_DATE("2018-08-09", "%Y-%m-%d") );

CALL order_details_in_period( STR_TO_DATE("2018-08-01", "%Y-%m-%d"),STR_TO_DATE("2017-08-9", "%Y-%m-%d") );