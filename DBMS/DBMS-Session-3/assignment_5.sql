# 1 : Create a view displaying the order information 
#     (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
#     with latest ordered items should be displayed first for last 60 days.

CREATE VIEW Order_Information AS
SELECT 
	Product.ID, 
    Product.title AS Title, 
    Product.price AS Price, 
    User.name AS 'Name', 
    User.mail AS 'Email', 
	Orders.order_date, 
    Products_In_Order.order_status 
FROM 
	User 
    LEFT JOIN 
    Orders 
    ON User.ID = Orders.user_ID
	LEFT JOIN 
    Products_In_Order 
    ON Products_In_Order.order_ID = Orders.ID
    LEFT JOIN 
    Product 
    ON Product.ID = Products_In_Order.product_ID
WHERE order_date >= CURRENT_DATE - 60
ORDER BY order_date;

# 2 : Use the above view to display the Products(Items) which are in ‘shipped’ state.

SELECT ID, Title, Price, order_status AS 'Status'
FROM Order_Information 
WHERE order_status = 'shipped';

# 3 : Use the above view to display the top 5 most selling products.

SELECT ID, Title, Price, COUNT(ID) AS 'Sold Items'
FROM Order_Information 
GROUP BY ID;