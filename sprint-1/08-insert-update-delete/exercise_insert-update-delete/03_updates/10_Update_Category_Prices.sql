USE northwind;

-- Write a script that updates the price of all products 
-- within a category by a certain percent.

SET @category_id = 1; -- INSERT CATEGORY ID
SET @percent_change = 50; -- INSERT PERCENT 50%

UPDATE products
SET unit_price = CONVERT(unit_price - (unit_price * (@percent_change / 100)), FLOAT)
WHERE category_id = @category_id;

SELECT * FROM products;