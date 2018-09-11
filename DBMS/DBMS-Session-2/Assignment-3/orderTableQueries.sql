# 1 : Display Recent 50 Orders placed (Id, Order Date, Order Total).

SELECT 
    ID, ORDER_DATE, ORDER_AMOUNT
FROM
    Orders
ORDER BY order_date DESC
LIMIT 50;

# 2 : Display 10 most expensive Orders.

SELECT 
    ID, USER_ID, ORDER_DATE, ORDER_AMOUNT
FROM
    Orders
ORDER BY order_amount DESC
LIMIT 10;

# 3 : Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.

SELECT ID, Orders.user_ID AS USER_ID, ORDER_DATE, ORDER_AMOUNT
FROM Orders INNER JOIN Products_In_Order ON Orders.ID = Products_In_Order.order_ID
WHERE order_date < CURRENT_DATE - 10 
AND NOT order_status = 'shipped';

# 4 : Display list of shoppers which haven't ordered anything since last month.

SELECT User.ID, User.name as Shopper_name
FROM User
WHERE User.ID NOT IN 
(SELECT User.ID FROM User INNER JOIN Orders ON User.ID = Orders.user_id WHERE Orders.order_date >= CURRENT_DATE - 30 );

# 5 : Display list of shopper along with orders placed by them in last 15 days. 

SELECT User.ID, User.name as Shopper_name, OrderS.ID AS Order_ID, Orders.order_date AS Order_date
FROM User INNER JOIN Orders ON User.ID = Orders.user_id
WHERE Orders.order_date >= CURRENT_DATE - 15;

# 6 : Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))

SELECT 
    ORDER_ID,
    USER_ID,
    PRODUCT_ID,
    PRODUCT_QUANTITY,
    ORDER_STATUS
FROM
    Products_In_Order
WHERE
    order_status = 'shipped' AND order_ID = 1020;

# 7 : Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.

SELECT 
    ORDER_ID,
    Products_In_Order.user_ID as USER_ID,
    PRODUCT_ID,
    Product.title as Title,
    PRODUCT_QUANTITY,
    ORDER_STATUS,
    Orders.order_date AS ORDER_DATE
FROM
    Products_In_Order
        INNER JOIN
    Orders ON Products_In_Order.order_ID = Orders.ID
        INNER JOIN
    Product ON Products_In_Order.product_ID = Product.ID
WHERE
    Product.price >= 20 AND Product.price <= 50;

# 8 : Update first 20 Order items status to “Shipped” which are placed today.

CREATE VIEW shippedItems AS SELECT product_ID FROM Products_In_Order LEFT JOIN Orders ON Products_In_Order.product_ID = Orders.ID WHERE order_date = CURRENT_DATE ORDER BY order_date;
UPDATE Products_In_Order SET order_status = 'shipped' 
WHERE product_ID IN ( SELECT product_ID FROM shippedItems);