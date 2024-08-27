-- 18. Count the number of customers in each country
-- include the country and total_customer_count
-- (use customers table)

-- (21 rows)

USE northwind;

SELECT country
	, COUNT(*) AS total_customer_count 
FROM customer_orders
GROUP BY country
ORDER BY total_customer_count DESC -- Added this for better visual



