-- 12. Most Popular film report
-- return the name of the 10 most popular films
-- title and number of times each film was rented

-- which tables will you need to join?

-- Same tables used in previous question i just reordered
-- the result. rental > inventory > film

--
-- (10 rows)

USE sakila;

SELECT f.title AS movie_title
    , COUNT(*) AS times_rented
FROM rental r
INNER JOIN inventory i
	ON i.inventory_id = r.inventory_id
INNER JOIN film f
	ON i.film_id = f.film_id
GROUP BY f.title
ORDER BY times_rented DESC
LIMIT 10;





