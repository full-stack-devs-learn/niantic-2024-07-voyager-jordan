-- 4. Display the
        -- product_name,
        -- sales_price,
        -- quantity,
        -- sub_total (price * qty)
        -- total_discount (sub_total * discount %)
        -- line_total (sub_total - discount amount)

-- Display all rows where the total discount is  over $1000.
-- (Use the customer_orders View)


-- Order the results by total_discount, highest first.
-- (8 rows)
use northwind;

SELECT product_name
		, sales_price
		, quantity
        , list_price * quantity AS sub_total
        , (list_price * quantity) * discount AS total_discount
        , (list_price * quantity) - ((list_price * quantity) * discount) AS line_total
FROM customer_orders
HAVING total_discount > 1000
ORDER BY total_discount desc;


