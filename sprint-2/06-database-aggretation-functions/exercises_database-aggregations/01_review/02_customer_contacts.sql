-- 2. Return the Company Name, Contact Name, Contact Title and city_state_zip
-- for each customer outside the United States
-- (Use the customers table)

-- The city state and zip should be in a single column named city_state_zip
-- and be formatted as "San Francisco, CA 94117"
--
-- Most regions outside the United States are NULL values,
-- the city_state_zip column should not display any NULL

-- (78 Rows)
USE northwind;

SELECT * FROM customers;

SELECT company_name
	, contact_name
    , contact_title
	, COALESCE (CONCAT(city,", ", region,", ", postal_code), "") AS city_state_zip
FROM customers
WHERE NOT country = "USA"


