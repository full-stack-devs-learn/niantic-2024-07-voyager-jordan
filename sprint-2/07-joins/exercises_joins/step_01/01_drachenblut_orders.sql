-- 1. The Company Name, Order Id, Order Date and Shipped Date
-- for all orders that were placed by Drachenblut Delikatessen. 
-- Order the results by shipped date, newest to oldest.
-- (6 rows)

USE northwind;

SELECT c.company_name
	, o.order_id
    , o.order_date
    , o.shipped_date
FROM customers c
INNER JOIN orders o
	ON o.customer_id = c.customer_id
WHERE company_name = "Drachenblut Delikatessen"
ORDER BY shipped_date DESC;

