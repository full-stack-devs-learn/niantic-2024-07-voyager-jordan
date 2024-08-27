-- 4. I want to know what category is the most popular
-- category for my best customer.

-- SELECT the Company Name, Category, and the OrderCount
-- for Save-a-lot Markets. (my best customer)
-- (the order count specifies how many times a category
-- was included in their orders)

-- sort in the order of the most ordered category to the least

-- (8 rows)

USE northwind;

SELECT c.company_name
	, ca.category_name
    , COUNT(*) AS OrderCount
FROM customers c
INNER JOIN orders o 
	ON o.customer_id = c.customer_id
INNER JOIN order_details od 
	ON o.order_id = od.order_id
INNER JOIN products p 
	ON p.product_id = od.product_id
INNER JOIN categories ca
	ON p.category_id = ca.category_id
WHERE c.company_name = "Save-a-lot Markets"
GROUP BY c.company_name, ca.category_name;


