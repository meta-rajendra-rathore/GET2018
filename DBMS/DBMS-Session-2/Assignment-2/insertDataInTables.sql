SHOW DATABASES;
USE storefront;
SHOW TABLES;

INSERT INTO User ( name, mail, isadmin, password, birth_date, contact_no) 
VALUES ( 'Rajendra', 'rajendra@gmail.com', true, 'password', STR_TO_DATE('05-06-1996', '%d-%m-%Y'), 9873646289 );

INSERT INTO User ( name, mail, isadmin, password, birth_date, contact_no) 
VALUES ( 'Mahesh', 'mahesh@gmail.com', false, 'password123', STR_TO_DATE('25-10-1997', '%d-%m-%Y'), 8763573637 );

LOAD DATA LOCAL INFILE 'D:/rajen/Documents/DBMS/DBMS-Session-1/Assignment-2/insertInUser.txt'
INTO TABLE User
FIELDS TERMINATED BY ', ' 
ENCLOSED BY '"' 
LINES TERMINATED BY '\r\n'
(name, mail, isadmin, password, contact_no);

INSERT INTO Address ( user_ID, user_contact_no, flat_no, street, city, state, country, zipcode) 
VALUES ( 2, '7746283783', '34/447', 'Haldigati marg', 'Jaipur', 'Rajasthan', 'India', '302033');

INSERT INTO Address ( user_ID, user_contact_no, flat_no, street, city, state, zipcode) 
VALUES ( 2, '8473839389', '34/447', 'Rana sanga marg', 'Guwahati', 'Asam', '47389');

LOAD DATA LOCAL INFILE 'D:/rajen/Documents/DBMS/DBMS-Session-1/Assignment-2/insertInAddress.txt'
INTO TABLE Address
FIELDS TERMINATED BY ', ' 
ENCLOSED BY '"' 
LINES TERMINATED BY '\r\n'
( user_ID, user_contact_no, flat_no, street, city, state, zipcode);