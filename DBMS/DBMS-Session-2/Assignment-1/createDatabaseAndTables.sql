SHOW DATABASES;
CREATE DATABASE storefront;
SHOW DATABASES;
USE Storefront;

CREATE TABLE User (
    ID INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    mail VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(20) NOT NULL,
    isadmin BOOLEAN NOT NULL DEFAULT FALSE,
    birth_date DATE,
    contact_no VARCHAR(10),
    PRIMARY KEY (ID)
);

CREATE TABLE Address (
    ID INT NOT NULL AUTO_INCREMENT,
    user_ID INT,
    user_contact_no INT NOT NULL,
    flat_no VARCHAR(10),
    street VARCHAR(30),
    city VARCHAR(15),
    state VARCHAR(20),
    country VARCHAR(30),
    zipcode INT(6) ZEROFILL NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (user_ID)
        REFERENCES User (ID)
);

CREATE TABLE Category (
    ID INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    parent_category_ID INT,
    PRIMARY KEY (ID)
);

CREATE TABLE Product (
    ID INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(30),
    category_ID INT,
    product_description VARCHAR(200),
    price INT,
    stock_quantity INT,
    is_enable BOOLEAN DEFAULT TRUE,
    modify_time DATE,
    PRIMARY KEY (ID),
    FOREIGN KEY (Category_ID)
        REFERENCES Category (ID)
);

CREATE TABLE Image (
    ID INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30),
    product_ID INT,
    image_URL VARCHAR(100),
    PRIMARY KEY (ID),
    FOREIGN KEY (product_ID)
        REFERENCES Product (ID)
);

CREATE TABLE Orders (
    ID INT NOT NULL,
    user_ID INT,
    order_date DATE,
    order_quantity INT,
    order_amount INT,
    shipping_address VARCHAR(300),
    order_status VARCHAR(12),
    PRIMARY KEY (ID),
    FOREIGN KEY (user_ID)
        REFERENCES User (ID)
);

CREATE TABLE Products_In_Order (
    order_ID INT,
    product_ID INT,
    PRIMARY KEY (Order_ID)
);