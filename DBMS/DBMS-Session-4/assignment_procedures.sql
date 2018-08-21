/* 1. 
Create a Stored procedure to retrieve average sales of each product in a month. 
Month and year will be input parameter to function. */

USE storefront;

DELIMITER $$
CREATE PROCEDURE avg_sales_in_month (
    IN query_month INT,
    IN query_year INT,
    OUT avg_sales DECIMAL )
BEGIN
    SELECT TRUNCATE(SUM(product_quantity)/COUNT(product_ID), 2) INTO avg_sales FROM Products_In_Order GROUP BY PRODUCT_ID;
END $$

CALL avg_sales_in_month(8, 2018, @avg_sales);
SELECT @avg_sales;
    
/* 2.
Create a stored procedure to retrieve table having order detail with status for a given period. 
Start date and end date will be input parameter. Put validation on input dates like start date is less than end date. 
If start date is greater than end date take first date of month as start date. */

DELIMITER $$
CREATE PROCEDURE avg_sales (
    IN 
    IN 
    OUT 
    OUT 
    
)
BEGIN

END $$