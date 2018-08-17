SHOW DATABASES;
USE storefront;
SHOW TABLES;

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

SHOW TABLES;