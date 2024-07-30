USE northwind;

-- The Product name, price and category id
-- of all dairy products

-- Expected: 10 rows

-- *** NOTE i also queried the category name so i can see if all the products were actually Diary ***
-- SELECT * FROM products;
-- SELECT * FROM categories;

SELECT products.product_name
	, unit_price
	, products.category_id
    , categories.category_name
FROM products
JOIN categories
ON products.category_id = categories.category_id
WHERE categories.category_name LIKE '%Dairy%';

