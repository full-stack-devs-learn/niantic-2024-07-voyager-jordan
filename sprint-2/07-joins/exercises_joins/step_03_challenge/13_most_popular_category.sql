-- 13. Category popularity report

-- return a list of category names and the number of times
-- a film in that category has been rented

-- sort by most popular category first

-- (16 rows)

USE sakila;

SELECT c.name AS category_name
    , COUNT(*) AS times_rented
FROM rental r
INNER JOIN inventory i
	ON i.inventory_id = r.inventory_id
INNER JOIN film f
	ON i.film_id = f.film_id
INNER JOIN film_category fc
	ON f.film_id = fc.film_id
INNER JOIN category c
	ON fc.category_id = c.category_id
GROUP BY c.name
ORDER BY times_rented DESC


