-- 9. Most Popular Film Categories
-- Return the total number of actors
-- who have acted in a category
-- sort most popular category to least

-- Columns: category_name, actor_count
--
-- (16 rows)



USE sakila;

SELECT c.name AS category_name
	, COUNT(*) AS actor_count
FROM category c
INNER JOIN film_category fc
	ON fc.category_id = c.category_id
INNER JOIN film f
	ON f.film_id = fc.film_id
GROUP BY c.name
ORDER BY actor_count DESC;



