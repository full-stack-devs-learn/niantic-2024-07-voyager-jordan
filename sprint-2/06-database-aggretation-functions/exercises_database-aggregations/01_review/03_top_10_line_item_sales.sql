-- 3. Display the
        -- product_name,
        -- sales_price,
        -- quantity,
        -- sub_total (price * qty)
        -- total_discount (sub_total * discount %)
        -- line_total (sub_total - discount amount)

-- Display the top 10 most expensive line items.
-- (Use the customer_orders View)


-- Order the results by line_total, highest first.
-- (10 rows)

USE northwind;

SELECT * FROM customer_orders;

SELECT product_name
		, sales_price
		, quantity
        , list_price * quantity AS sub_total
        , (list_price * quantity) * discount AS total_discount
        , (list_price * quantity) - ((list_price * quantity) * discount) AS line_total
FROM customer_orders
ORDER BY line_total desc



