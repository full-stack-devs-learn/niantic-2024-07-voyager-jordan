USE northwind;

-- Insert 10 new products into the new Sporting Goods Category
-- You can leave the Supplier Id empty for now, but you need to include
-- the product name, category, price, units in stock (20), units on order (0)
-- and re-order level (10) for each product.

SELECT * FROM products WHERE category_id = 9;

INSERT products 
(
	product_name
	, category_id
	, unit_price
	, units_in_stock
	, units_on_order
	, reorder_level
)
VALUE 
	('Pro Performance Basketball', 9, 29.99, 20, 0, 10)
    , ('Elite Soccer Cleats', 9, 89.99, 20, 0, 10)
    , ('High-Density Yoga Mat', 9, 39.99, 20, 0, 10)
    , ('Durable Tennis Racket', 9, 119.99, 20, 0, 10)
    , ('Adjustable Dumbbells Set', 9, 199.99, 20, 0, 10)
    , ('Pro Series Baseball Glove', 9, 79.99, 20, 0, 10)
    , ('Performance Running Shoes', 9, 129.99, 20, 0, 10)
    , ('Multi-Function Jump Rope', 9, 24.99, 20, 0, 10)
    , ('Heavy Duty Resistance Bands', 9, 34.99, 20, 0, 10)
    , ('High Impact Protective Helmet', 9, 64.99, 20, 0, 10);

