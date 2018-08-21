use storefront;

/*Given the id of a user, fetch all orders (Id, Order Date, Order Total) of that user which are in shipped state. 
Orders should be sorted by order date column in chronological order.*/

SELECT Product.ID, Orders.order_date, Orders.order_amount 
FROM 
    Product 
    INNER JOIN Products_In_order ON product.ID = product_ID 
    INNER JOIN Orders ON order_ID = orders.ID 
WHERE order_status = "shipped" AND user_ID = 2
ORDER BY order_date;



#Insert five or more images of a product using batch insert technique.

INSERT INTO Image ( name, product_ID, image_URL )
VALUES ( 'Front', 2, 'www.mystorage.come/project1/product2/Front' );

# set  all those products which were not ordered by any Shopper in last 1 year as inactive and return number of inactive products.
SET SQL_SAFE_UPDATES  = 1;
UPDATE Product SET is_enable = 1 WHERE ID NOT IN  
( SELECT product_ID from Products_In_Order LEFT JOIN Orders ON order_ID = ID WHERE order_date >= CURDATE() - 365);

SELECT ID,TITLE FROM Product WHERE ID NOT IN  
( SELECT product_ID from Products_In_Order LEFT JOIN Orders ON order_ID = ID WHERE order_date >= CURDATE() - 365);

# Select and display the category title of all top parent categories sorted alphabetically and the count of their child categories.

SELECT parent.Name, COUNT(parent.ID) AS 'No of Child Categories' 
FROM Category parent LEFT JOIN Category child ON parent.ID = child.parent_category_ID
WHERE parent.parent_category_ID IS NULL 
GROUP BY child.parent_category_ID;