SELECT 
    ID, ORDER_DATE, ORDER_AMOUNT
FROM
    Orders
ORDER BY order_date DESC
LIMIT 15;

SELECT 
    ID, USER_ID, ORDER_DATE, ORDER_AMOUNT
FROM
    Orders
ORDER BY order_amount DESC
LIMIT 10;

SELECT DISTINCT
    ID, Orders.user_ID AS USER_ID, ORDER_DATE, ORDER_AMOUNT
FROM
    Orders
        INNER JOIN
    Products_In_Order ON Orders.ID = Products_In_Order.order_ID
WHERE
    order_date < CURRENT_DATE - 10
        AND NOT order_status = 'shipped';

SELECT 
    User.ID, User.name AS Shopper_name
FROM
    User
WHERE
    User.ID NOT IN (SELECT 
            User.ID
        FROM
            User
                INNER JOIN
            Orders ON User.ID = Orders.user_id
        WHERE
            Orders.order_date >= CURRENT_DATE - 30);

SELECT 
    User.ID,
    User.name AS Shopper_name,
    OrderS.ID AS Order_ID,
    Orders.order_date AS Order_date
FROM
    User
        INNER JOIN
    Orders ON User.ID = Orders.user_id
WHERE
    Orders.order_date >= CURRENT_DATE - 15;

SELECT 
    ORDER_ID, PRODUCT_ID, Title, PRODUCT_QUANTITY, ORDER_STATUS
FROM
    Products_In_Order
        INNER JOIN
    Product ON Products_In_Order.product_ID = Product.ID
WHERE
    order_status = 'shipped'
        AND order_ID = 2;

SELECT 
    ORDER_ID,
    PRODUCT_ID,
    Product.title AS Title,
    Price,
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
    Product.price >= 500
        AND Product.price <= 3900;

# 8 : Update first 20 Order items status to “Shipped” which are placed today.

DROP VIEW shippedItems;
CREATE VIEW shippedItems AS
    SELECT DISTINCT
        Products_In_Order.product_ID
    FROM
        Products_In_Order
            LEFT JOIN
        Orders ON Products_In_Order.product_ID = Orders.ID
    WHERE
        order_date = CURRENT_DATE
    ORDER BY order_date;
    
UPDATE Products_In_Order 
SET 
    order_status = 'shipped'
WHERE
    product_ID IN (SELECT 
            product_ID
        FROM
            shippedItems) AND NOT product_ID = -1;