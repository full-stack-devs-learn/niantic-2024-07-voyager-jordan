USE northwind;

-- Delete the Sporting Goods Catregory from the database.

-- Why does it fail to delete?

-- What else needs to be done to fully delete the Category?

-- Write a script that preforms all necessary steps to 
-- delete the category from the database.

-- The only user input should be a variable at the top of the 
-- script that holds the Category Name.
-- The sript should do the rest
SELECT * FROM order_details;
SELECT * FROM products;
SELECT * FROM categories;

-- DELETE ORDER-DETAILS
DELETE FROM order_details
WHERE product_id IN (
	SELECT product_id
    FROM products p
    WHERE p.category_id IN (
		SELECT category_id
        FROM categories
        WHERE category_name = 'Sporting Goods'
    )
);

DELETE FROM products p
    WHERE p.category_id IN (
		SELECT category_id
        FROM categories
        WHERE category_name = 'Sporting Goods'
);

DELETE FROM categories
WHERE category_name = 'Sporting Goods';

SELECT * FROM categories;
