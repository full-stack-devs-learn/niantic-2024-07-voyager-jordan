USE northwind;

-- You were just hired by Northwind Traders, Inc and 
-- you need to add yourself as a Sales Associate to the Employees table.
-- Inlcude your:
    -- full name
    -- job title
    -- preferred title (Mr, Mrs, etc)
    -- Birthday
    -- hire date: (today)
    -- home address
-- leave all other fields null by default
SELECT * FROM employees;

INSERT employees (
	first_name
    , last_name
    , title
    , title_of_courtesy
    , birth_date
    , hire_date
    , address
    , notes
) 
VALUES (
	'Jordan'
    , 'Napoleon'
    , 'Sales Associate'
    , 'Mr.'
    , '1997-01-24 00:00:00'
    , NOW()
    , '123 Niantic Lane'
    , 'DOESNT HAVE NULL VALUE'
);

-- I couldn't leave me data not uniform i had to update
-- UPDATE employees SET title_of_courtesy='Mr.' WHERE employee_id = 10;

