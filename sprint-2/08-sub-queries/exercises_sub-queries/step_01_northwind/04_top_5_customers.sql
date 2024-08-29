-- 4. Using only sub-queries
-- Display the names of my top 5 customer
-- and the number of orders each has placed
-- the number of orders  determines top customer

-- (first 5 rows)
-- Save-a-lot Markets               31
-- Ernst Handel                     30
-- QUICK-Stop                       28
-- Folk och f HB                    19
-- Hungry Owl All-Night Grocers     19


USE northwind;

-- Does this count as a sub-query?
-- Now that I know whats going on thought I try it out again.

WITH order_count AS (
	SELECT *
    FROM orders o
), 
company_names AS (
	SELECT c.company_name
		, c.customer_id
    FROM customers c
)
SELECT cn.company_name
	, COUNT(*) AS orders_placed
FROM order_count oc
INNER JOIN company_names AS cn
WHERE cn.customer_id = oc.customer_id
GROUP BY cn.company_name
ORDER BY orders_placed DESC
LIMIT 5;


