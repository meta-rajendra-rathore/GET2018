# 1 : Display Shopper’s information along with number of orders he/she placed during last 30 days.

SELECT 
	User.ID, 
    User.name AS Shopper_name, 
    Mail, 
    Birth_date, 
    COUNT(Orders.ID) AS 'Orders in last 30 days'
FROM 
	User INNER 
    JOIN 
    Orders 
	ON User.ID = Orders.user_id
WHERE 
	Orders.order_date >= CURRENT_DATE - 30
GROUP BY 
	user_ID 
ORDER BY COUNT(Orders.ID) DESC;

# 2 : Display the top 3 Shoppers who generated maximum number of revenue in last 30 days.
        
SELECT 
	User.ID, 
    User.name AS Shopper_name, 
    Mail, 
    Birth_date, 
    SUM(Orders.order_amount) AS 'Total revenue in last 30 days'
FROM 
	User 
    INNER JOIN 
	Orders 
    ON User.ID = Orders.user_id
WHERE 
	Orders.order_date >= CURRENT_DATE - 30 
GROUP BY 
	user_ID 
ORDER BY 
	SUM(Orders.order_amount) DESC 
LIMIT 3;

# 3 : Display top 10 Products which are ordered most in last 60 days along with numbers.

SELECT 
	Product.ID, 
    Title, 
    Price AS 'Unit Price',
    SUM(Products_In_Order.product_quantity) AS 'Total ordered quantity'
FROM 
	Product 
    LEFT JOIN
    Products_In_Order 
    ON Product.ID = Products_In_Order.product_ID
    LEFT JOIN
	Orders 
    ON Orders.ID = Products_In_Order.order_ID
WHERE 
	Orders.order_date >= CURRENT_DATE - 60 
GROUP BY 
	Products_In_Order.product_ID
ORDER BY 
	SUM(Products_In_Order.product_quantity) DESC 
LIMIT 10;

# 4 : Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.

SELECT 
	MONTHName(order_date) AS 'Month',
    SUM(order_amount) AS 'Total Monthly revenue'
FROM
	Orders
GROUP BY MONTH(order_date), YEAR(order_date)
ORDER BY order_date DESC
LIMIT 6;

# 5 : Mark the products as Inactive which are not ordered in last 90 days.

UPDATE Product SET is_enable = 0 WHERE NOT ID = -1 AND ID NOT IN 
( SELECT DISTINCT Products_In_Order.product_ID 
	FROM 
		Products_In_Order
		LEFT JOIN 
		Orders  
		ON Orders.ID = Products_In_Order.product_ID 
	WHERE Orders.order_date >= CURRENT_DATE - 90);

# 6 : Given a category search keyword, display all the Products present in this category/categories. 

SELECT 
	Product.ID, 
    Title, 
    product_description AS 'Product Description',
    Category.name,
    Price AS 'Unit Price'
FROM
	Category 
    LEFT JOIN
    Category_of_product
    ON Category.ID = Category_of_product.category_ID
    LEFT JOIN
    Product
    ON Category_of_product.product_ID = Product.ID
WHERE Category.name = 'Mobiles';

# 7 : Display top 10 Items which were cancelled most.

SELECT 
	Product.ID, 
    Title, 
    product_description AS 'Product Description',
    Price AS 'Unit Price',
    COUNT(Products_In_Order.order_status) AS 'No of times shipped' 
FROM
	Product
    LEFT JOIN
    Products_In_Order
    ON Product.ID = Products_In_Order.product_ID
WHERE Products_In_Order.order_status = 'shipped'
GROUP BY Products_In_Order.product_ID
ORDER BY COUNT(Products_In_Order.order_status);