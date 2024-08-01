USE northwind;

-- Delete the Sporting Goods Catregory from the database.

-- Why does it fail to delete?

-- What else needs to be done to fully delete the Category?

-- Write a script that preforms all necessary steps to 
-- delete the category from the database.

-- The only user input should be a variable at the top of the 
-- script that holds the Category Name.
-- The sript should do the rest
SET @delete_me = 'Sporting Goods';

-- DELETE ORDER-DETAILS
DELETE FROM order_details
WHERE product_id IN (
	SELECT product_id
    FROM products p
    WHERE p.category_id IN (
		SELECT category_id
        FROM categories
        WHERE category_name = @delete_me
    )
);

DELETE FROM products p
    WHERE p.category_id IN (
		SELECT category_id
        FROM categories
        WHERE category_name = @delete_me
);

DELETE FROM categories
WHERE category_name = @delete_me;

SELECT * FROM categories;
