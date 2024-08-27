-- 16. Total sales by any customer who has spent more than $10000
-- Include the CompanyName, State and TotalSales
-- Sort by total sales desc
-- (Use the customer_orders view)

-- (6 rows)

USE northwind;

SELECT company_name
	, region
    , sales_price * quantity AS TotalSales
FROM customer_orders
GROUP BY company_name, region, TotalSales
HAVING TotalSales > 10000
ORDER BY TotalSales DESC;





