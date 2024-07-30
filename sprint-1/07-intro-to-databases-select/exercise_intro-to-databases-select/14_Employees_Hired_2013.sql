USE northwind;

-- The employee name and title
-- of all employees who were hired
-- in 2013

-- Expected: 3 rows
-- NOTE: I queried there hire_date as well;

SELECT CONCAT(first_name, ' ', last_name) AS Name
	, hire_date
FROM employees
WHERE hire_date LIKE '2013%'

