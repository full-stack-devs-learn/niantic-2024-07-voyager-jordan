USE northwind;

-- Write a script that updates the price of all products 
-- within a category by a certain percent.
SET @category_to_update = 'Beverages'; -- SET CATEGORY NAME
SET @percent_change = 50; -- SET INCREASE/DECREASE IN PERCENT 50%

UPDATE products
SET unit_price = ROUND(unit_price + (unit_price * (@percent_change / 100)), 2)
WHERE category_id = (SELECT category_id FROM categories WHERE category_name = @category_to_update);

SELECT * FROM products;