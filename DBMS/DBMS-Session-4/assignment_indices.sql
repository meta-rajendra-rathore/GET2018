-- Identify the columns require indexing in order, product, category tables and create indexes.

USE storefront;

# 1. Orders

ALTER TABLE Orders ADD INDEX user_ID_index(user_ID);

# 2. Product

ALTER TABLE Product ADD INDEX title_index(title);

# 3. Category

ALTER TABLE Category ADD INDEX parent_ID_index(parent_category_ID);