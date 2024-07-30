USE northwind;

-- The company_name, contact_name and phone of 
-- all customers for whom we do
-- not have a fax number

-- Expected: 22 rows

SELECT * FROM customers;

SELECT company_name
	, contact_name
    , phone
    , fax
FROM customers
WHERE fax IS NULL

