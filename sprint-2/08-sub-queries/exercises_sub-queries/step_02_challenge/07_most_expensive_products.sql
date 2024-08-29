-- 7. expensive products report

-- Display the most expensive product in each category

-- Columns to include:
-- Category Name
-- Product Name
-- Unit price

-- NOTE: you can combine INNER JOIN and sub queries in the
-- query if you would like

-- (8 rows - one per category)
-- Beverages        Cte de Blaye            263.5000
-- Condiments       Vegie-spread            43.9000
-- Confections      Sir Rodney's Marmalade  81.0000
-- Dairy Products   Raclette Courdavault    55.0000
-- Grains/Cereals   Gnocchi di nonna Alice  38.0000
-- Meat/Poultry     Thringer Rostbratwurst  123.7900
-- Produce          Manjimup Dried Apples   53.0000
-- Seafood          Carnarvon Tigers        62.5000


USE northwind;

SELECT sub.category_name
	, product_name
    , sub.most_expensive
FROM products p
INNER JOIN (
	SELECT c.category_name AS category_name
		, c.category_id
		, MAX(unit_price) AS most_expensive
	FROM products p
	INNER JOIN categories c WHERE p.category_id = c.category_id
	GROUP BY category_name, category_id
) AS sub
WHERE p.unit_price = sub.most_expensive AND p.category_id = sub.category_id
ORDER BY category_name;







