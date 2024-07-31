USE northwind;

-- Insert a new category into the Categories table
-- category name: Sporting Goods
-- description: All products that relate to recreational activities.
--              This includes equipment needed for team sports as well
--              as outdoor activities such as camping or river rafting.

SELECT * FROM categories;

INSERT categories (category_name, description)
VALUE 
(
'Sporting Goods', 'All products that relate to recreational activities.
This includes equipment needed for team sports as well
as outdoor activities such as camping or river rafting.'
);

-- NOTE: These are here because my return wasnt quite correct it had weird spaces 

-- UPDATE categories SET description='All products that relate to recreational activities. This includes equipment needed for team sports as well as outdoor activities such as camping or river rafting.' WHERE category_name = 'Sporting Goods'
-- DELETE FROM categories WHERE category_id = 10;