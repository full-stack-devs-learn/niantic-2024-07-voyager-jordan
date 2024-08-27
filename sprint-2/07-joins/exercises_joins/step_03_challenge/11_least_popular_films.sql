-- 11. Least Popular film report
-- return the name of the 20 least popular films
-- title and number of times each film was rented

-- which tables will you need to join?

-- I started at the rented table because it was a report on
-- how much times a movie was rented. Then I figured out how to get
-- from rental >> film title. After further look i seen that inventory table had a film id column
-- so I used rental table > inventory > film table

--
-- (20 rows)

USE sakila;

SELECT f.title AS movie_title
    , COUNT(*) AS times_rented
FROM rental r
INNER JOIN inventory i
	ON i.inventory_id = r.inventory_id
INNER JOIN film f
	ON i.film_id = f.film_id
GROUP BY f.title
ORDER BY times_rented
LIMIT 20;

	



