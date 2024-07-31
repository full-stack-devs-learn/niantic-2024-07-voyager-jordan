USE northwind;

-- Return all countries and cities where we 
-- have customers

-- Expected: 69 Rows

-- SELECT * FROM customers;

SELECT DISTINCT country
	, city
FROM customers;

