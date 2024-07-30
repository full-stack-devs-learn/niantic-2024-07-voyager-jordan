USE northwind;

-- The Product name, price and the number
-- of units available for sale (in stock + on order)
-- of all dairy products

-- Hint: Be sure to create a column alias for 
-- the new column

-- Expected: 10 rows

-- NOTE: I cant figure out why the top query doesnt pull data but the bottom one does i typed out the top and thought it was correct
-- NOTE: but it was not working so i copy and pasted my solution from the previous step and it worked WHYYYY.

-- SELECT * FROM products ;
-- SELECT * FROM categories;

SELECT product_name
	, unit_price
    , units_in_stock + units_on_order AS 'items_available'
FROM products p
JOIN categories c
ON p.category_id = c.category_id
WHERE c.category_name LIKE '%Diary%';

SELECT product_name
	, unit_price
    , units_in_stock + units_on_order AS 'items_available'
FROM products p
JOIN categories c
ON p.category_id = c.category_id
WHERE c.category_name LIKE '%Dairy%';