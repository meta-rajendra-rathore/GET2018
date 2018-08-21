SHOW DATABASES;
USE storefront;

# 1 : Create a function to calculate number of orders in a month. Month and year will be input parameter to function.

DELIMITER $$
CREATE FUNCTION count_orders_in_month ( query_month INT, query_year INT) RETURNS INT
DETERMINISTIC 
BEGIN
    DECLARE no_of_orders INT;
    SELECT COUNT(ID) INTO no_of_orders FROM Orders WHERE MONTH(Orders.order_date) = query_month AND YEAR(Orders.order_date) = query_year;
    RETURN no_of_orders;
END $$

SELECT MONTHNAME(STR_TO_DATE(8, '%m')) AS Month, count_orders_in_month( 8 , 2017) AS 'Orders in Month 8, 2017';

# 2 : Create a function to return month in a year having maximum orders. Year will be input parameter.

DELIMITER ^^
CREATE FUNCTION month_with_max_order ( query_year INT) RETURNS VARCHAR(10)
DETERMINISTIC 
BEGIN
    DECLARE max_order_month INT;
    SELECT MAX(order_count) INTO max_order_month
    FROM (
        SELECT COUNT(ID) AS order_count
        FROM Orders 
        WHERE YEAR(order_date) = query_year
        GROUP BY MONTH(order_date) 
    ) orders_in_month;
    RETURN MONTHNAME(STR_TO_DATE(max_order_month, '%m'));
END ^^

SELECT month_with_max_order(2018) AS 'Month with max orders in 2018';