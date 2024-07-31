USE northwind;

-- delete one of your new sporting goods products
-- from the database
-- choose one that has not been purchased

-- BEFORE
SELECT * FROM products;

DELETE FROM products WHERE product_id = 83;

-- AFTER
SELECT * FROM products;

