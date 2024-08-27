-- 8. Display the Category Name, and film title of all films
-- in the "Comedy" category

-- (58 rows)

USE sakila;

SELECT c.name AS Category_Name
	, f.title AS Film_Title
FROM category c
INNER JOIN film_category fc
	ON fc.category_id = c.category_id
INNER JOIN film f
	ON f.film_id = fc.film_id
WHERE c.name LIKE "Comedy"

