USE northwind;

-- The Product name, UnitsInStock
-- of all products that need to be re-ordered
-- (They are low stock and have not been 
-- re-ordered)

-- Expected: 1 row
-- NOTE: I queried units on order column to display that it hasnt been ordered.

SELECT product_name
	, units_in_stock
    , units_on_order
FROM products p
WHERE p.units_in_stock < p.reorder_level AND p.units_on_order = 0;

