# 1 : Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.

SELECT 
    Product.ID,
    Product.title AS Title,
    Category.name AS Category_Name,
    price as Price
FROM
    Product
        INNER JOIN
    Category_of_product ON Product.ID = Category_of_product.product_ID
		INNER JOIN
	Category ON Category.ID = Category_of_product.category_ID
WHERE
    is_enable = 1
ORDER BY modify_time DESC;

# 2 : Display the list of products which don't have any images.

SELECT DISTINCT
    Product.title as Products_with_no_Images
FROM
    Product,
    Image
WHERE
    Product.ID NOT IN (SELECT 
        Image.Product_ID
    FROM
        Image);

# 3 : Display all Id, Title and Parent Category Title for all the Categories listed, 
#     sorted by Parent Category Title and then Category Title. 
#     (If Category is top category then Parent Category Title column should display “Top Category” as value.)

SELECT 
    c.ID as ID,
    c.name as Title,
    IFNULL(p.name, 'Top Category') as Parent_Category_Name
FROM
    Category c
        LEFT JOIN
    Category p ON c.parent_category_ID = p.ID
ORDER BY p.name,c.name;

# 4 : Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)

SELECT 
    c.ID as ID, c.name as Title, p.name as Parent_Category_Name
FROM
    Category c
        LEFT JOIN
    Category p ON c.parent_category_ID = p.ID
WHERE
    c.ID NOT IN (SELECT 
        parent_category_ID
    FROM
        Category
    WHERE
        parent_category_ID IS NOT NULL);

# 5 : Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)

SELECT 
    TITLE, PRICE, PRODUCT_DESCRIPTION
FROM
    Product
        INNER JOIN
    Category_of_product ON Product.ID = Category_of_product.product_ID
		INNER JOIN
	Category ON Category.ID = Category_of_product.category_ID
WHERE
    Category.name = 'Mobiles';

# 6 : Display the list of Products whose Quantity on hand (Inventory) is under 50.

SELECT 
    TITLE, STOCK_QUANTITY
FROM
    Product
WHERE
    stock_quantity < 50;

# 7 : Increase the Inventory of all the products by 100.

UPDATE Product
SET stock_quantity = stock_quantity + 100
WHERE NOT ID = -1;
SELECT 
    *
FROM
    Product;