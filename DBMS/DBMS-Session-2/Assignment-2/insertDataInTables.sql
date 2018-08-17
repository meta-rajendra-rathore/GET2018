SHOW DATABASES;
USE storefront;
SHOW TABLES;

##########################################################################################

INSERT INTO User ( name, mail, isadmin, password, birth_date, contact_no) 
VALUES ( 'Rajendra', 'rajendra@gmail.com', true, 'password', STR_TO_DATE('05-06-1996', '%d-%m-%Y'), 9873646289 );

INSERT INTO User ( name, mail, isadmin, password, birth_date, contact_no) 
VALUES ( 'Mahesh', 'mahesh@gmail.com', false, 'password123', STR_TO_DATE('25-10-1997', '%d-%m-%Y'), 8763573637 );

LOAD DATA LOCAL INFILE 'D:/DBMS/DBMS-Session-2/Assignment-2/insertInUser.txt'
INTO TABLE User
FIELDS TERMINATED BY ', ' 
ENCLOSED BY '"' 
LINES TERMINATED BY '\r\n'
(name, mail, isadmin, password, @birth_date, contact_no)
SET birth_date = STR_TO_DATE(@birth_date, '%d-%m-%Y');

SELECT * FROM User;

##########################################################################################

INSERT INTO Address ( user_ID, user_contact_no, flat_no, street, city, state, country, zipcode) 
VALUES ( 2, '7746283783', '34/447', 'Haldigati marg', 'Jaipur', 'Rajasthan', 'India', '302033');

INSERT INTO Address ( user_ID, user_contact_no, flat_no, street, city, state, zipcode) 
VALUES ( 2, '8473839389', '34/447', 'Rana sanga marg', 'Guwahati', 'Asam', '47389');

LOAD DATA LOCAL INFILE 'D:/DBMS/DBMS-Session-2/Assignment-2/insertInAddress.txt'
INTO TABLE Address
FIELDS TERMINATED BY ', ' 
ENCLOSED BY '"' 
LINES TERMINATED BY '\r\n'
( user_ID, user_contact_no, flat_no, street, city, state, zipcode);

SELECT * FROM Address;

##########################################################################################

INSERT INTO Category ( name ) VALUES ( 'Electronics' );

INSERT INTO Category ( name, parent_category_ID) VALUES ( 'Mobiles', 1 );

LOAD DATA LOCAL INFILE 'D:/DBMS/DBMS-Session-2/Assignment-2/insertInCategory.txt'
INTO TABLE Category
FIELDS TERMINATED BY ', ' 
ENCLOSED BY '"' 
LINES TERMINATED BY '\r\n'
( name, parent_category_ID );

SELECT * FROM Category;

##########################################################################################

INSERT INTO Product ( title, category_ID, product_description, price, stock_quantity, is_enable, modify_time) 
VALUES ( 'MOTO G5S+', 2, 'A great phone with dual camera and long battery life from moto', 12999, 15, 1, CURRENT_TIMESTAMP);

INSERT INTO Product ( title, category_ID, product_description, price, stock_quantity, is_enable, modify_time) 
VALUES ( 'Pepe Jeans', 9, 'A rugged jeans from the known Pepe brand', 1300, 50, 1, CURRENT_TIMESTAMP);
truncate table product;
LOAD DATA LOCAL INFILE 'D:/DBMS/DBMS-Session-2/Assignment-2/insertInProduct.txt'
INTO TABLE Product
FIELDS TERMINATED BY ', ' 
ENCLOSED BY '"' 
LINES TERMINATED BY '\r\n'
( title, category_ID, product_description, price, stock_quantity, is_enable, @modify_time)
SET modify_time = CURRENT_TIMESTAMP;

SELECT * FROM Product;

##########################################################################################

INSERT INTO Image ( name, product_ID, image_URL )
VALUES ( 'Front', 2, 'www.mystorage.come/project1/product2/Front' );

INSERT INTO Image ( name, product_ID, image_URL )
VALUES ( 'Side1', 2, 'www.mystorage.come/project1/product2/Side1' );

LOAD DATA LOCAL INFILE 'D:/DBMS/DBMS-Session-2/Assignment-2/insertInImage.txt'
INTO TABLE Image
FIELDS TERMINATED BY ', ' 
ENCLOSED BY '"' 
LINES TERMINATED BY '\r\n'
( name, product_ID, image_URL );

SELECT * FROM Image;

##########################################################################################

LOAD DATA LOCAL INFILE 'D:/DBMS/DBMS-Session-2/Assignment-2/insertInOrders.txt'
INTO TABLE Orders
FIELDS TERMINATED BY ', ' 
ENCLOSED BY '"' 
LINES TERMINATED BY '\r\n'
( user_ID, order_date, order_amount, shipping_address_ID );

SELECT * FROM Orders;

##########################################################################################