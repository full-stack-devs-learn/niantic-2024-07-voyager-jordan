-- 10. Count of films in each category
-- that GRACE MOSTEL has appeared in as an actress

-- include first_name, last_name, category_name, film_count

-- (11 rows)

USE sakila;

SELECT a.first_name
	, a.last_name
    , c.name AS category_name
    , COUNT(*) AS film_count
FROM actor a
INNER JOIN film_actor fa
	ON fa.actor_id = a.actor_id
INNER JOIN film f
	ON f.film_id = fa.film_id
INNER JOIN film_category fc
	ON fc.film_id = f.film_id
INNER JOIN category c
	ON c.category_id = fc.category_id
WHERE a.first_name LIKE "GRACE" 
	AND a.last_name LIKE "MOSTEL"
GROUP BY a.first_name, a.last_name, c.name
ORDER BY film_count DESC
