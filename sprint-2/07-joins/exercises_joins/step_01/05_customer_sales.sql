-- 5. The order details table includes the line item for each sale.
-- the Line Total is the SalesPrice * Quantity - Discount%.

-- I want a customer sales report
-- include customer names (company_name), and their total sales amount (after discount)
-- sorted by sales total highest to lowest

-- The first 3 rows should be
-- CompanyName			SalesTotal
-- QUICK-Stop			110277.31
-- Ernst Handel			104874.98
-- Save-a-lot Markets	104361.95

-- (89 rows)

USE northwind;

SELECT c.company_name
	, SUM((od.unit_price * od.quantity) - (od.unit_price * od.discount * od.quantity))  AS SalesTotal
FROM customers c
INNER JOIN orders o 
	ON c.customer_id = o.customer_id
INNER JOIN order_details od 
	ON od.order_id = o.order_id
GROUP BY c.company_name
ORDER BY SalesTotal DESC;


