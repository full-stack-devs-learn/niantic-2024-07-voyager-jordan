-- 20. Return the State with the most number of orders placed.
-- Include state / region and order_count.
-- (use customer_orders view)

-- do not include any orders for customers whose state/region is unknow

-- (1 rows)
-- SP   49

USE northwind;

SELECT region
    , count(DISTINCT order_id) AS order_count
FROM customer_orders
WHERE NOT city = "null" AND NOT region = "null"
GROUP BY region
ORDER by order_count desc
LIMIT 1;





