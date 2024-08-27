-- 7. List the names of all actors who acted in
-- the film "HUMAN GRAFFITI"

-- (4 rows)

USE sakila;

SELECT a.actor_id
	, CONCAT(a.first_name, " ", a.last_name) AS Actors_Name
    , f.title
FROM actor a
INNER JOIN film_actor fa 
	ON fa.actor_id = a.actor_id
INNER JOIN film f 
	ON f.film_id = fa.film_id
WHERE f.title LIKE "HUMAN GRAFFITI"



