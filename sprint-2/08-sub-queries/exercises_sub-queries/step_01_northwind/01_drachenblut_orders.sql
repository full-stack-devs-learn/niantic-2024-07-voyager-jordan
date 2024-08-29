-- 1. Create a report to show
-- all orders that were placed by Drachenblut Delikatessen.

-- Columns to include:
-- -------------------
-- order_id
-- order_date
-- shipped_date


-- Order the results by shipped date, newest to oldest.
-- (6 rows)

-- Using only a sub-query (no INNER JOIN)


USE northwind;

SET @search_for_user = "Drachenblut Delikatessen";

SELECT order_id
	, order_date
    , shipped_date
FROM orders
WHERE customer_id = (
	SELECT customer_id
    FROM customers
    WHERE company_name = @search_for_user
)
ORDER BY shipped_date desc


