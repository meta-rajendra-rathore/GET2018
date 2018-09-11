USE storefront;

# 1 : Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.

SELECT ID, Title, COUNT(category_ID) AS 'No. of Categories'
FROM Product LEFT JOIN Category_of_product ON Product.ID = Category_of_product.product_ID 
GROUP BY (product_ID) HAVING COUNT(category_ID) > 1;

# 2 : Display Count of products as per below price range

SELECT 
	product_processed.price_range, 
    COUNT(price_range) AS ProductCount 
FROM
	(SELECT 
		CASE
		   WHEN price BETWEEN 0 AND 1000 THEN '0-1000'
		   WHEN price BETWEEN 1000 AND 5000 THEN '1000-5000'
		   ELSE 'Above 5000' 
		END 
        AS price_range
	    FROM 
			product) product_processed
GROUP BY product_processed.price_range;
    
# 3 : Display the Categories along with number of products under each category.

SELECT name, COUNT(product_ID) AS 'No. of Products' 
FROM Category LEFT JOIN Category_of_product ON Category.ID = Category_of_product.category_ID 
GROUP BY Category_of_product.category_ID ORDER BY name;
        