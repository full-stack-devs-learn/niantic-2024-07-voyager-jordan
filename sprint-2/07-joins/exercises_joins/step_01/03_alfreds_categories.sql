-- 3.  List of all the categories 
-- that Alfreds Futterkiste has ever ordered
-- (5 rows)

USE Northwind;

SELECT DISTINCT ca.category_name
FROM customers c
INNER JOIN orders o 
	ON o.customer_id = c.customer_id
INNER JOIN order_details od 
	ON o.order_id = od.order_id
INNER JOIN products p 
	ON p.product_id = od.product_id
INNER JOIN categories ca
	ON p.category_id = ca.category_id
WHERE c.company_name = "Alfreds Futterkiste";


