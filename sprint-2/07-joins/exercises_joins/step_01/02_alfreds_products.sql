-- 2. The name of all products that
-- have been ordered by Alfreds Futterkiste
-- Include each product only once
-- (11 rows)

USE Northwind;

SELECT DISTINCT c.company_name
	, p.product_name
FROM customers c
INNER JOIN orders o 
	ON o.customer_id = c.customer_id
INNER JOIN order_details od 
	ON o.order_id = od.order_id
INNER JOIN products p 
	ON p.product_id = od.product_id
WHERE company_name = "Alfreds Futterkiste";


