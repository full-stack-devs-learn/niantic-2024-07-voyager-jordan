-- 3. Create a product supplier report

-- Columns to include:
-- -------------------
-- Product Name
-- units in stock
-- Supplier Name


-- Use a sub query to display the Category Name
-- you are not allowed to use a JOIN statment

-- sort by product name

USE Northwind;

SELECT p.product_name
	, p.units_in_stock
    , (SELECT s.company_name FROM suppliers s WHERE p.supplier_id = s.supplier_id) AS Supplier_Name
FROM products p;


