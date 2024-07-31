USE northwind;

-- The Product name, price and the number
-- of units available for sale (in stock + on order)
-- of all dairy products

-- Hint: Be sure to create a column alias for 
-- the new column

-- Expected: 10 rows

-- SELECT * FROM products ;
-- SELECT * FROM categories;

SELECT product_name
	, unit_price
    , units_in_stock + units_on_order AS 'items_available'
    , c.category_name
FROM products p
JOIN categories c
WHERE c.category_name LIKE '%Dairy%';