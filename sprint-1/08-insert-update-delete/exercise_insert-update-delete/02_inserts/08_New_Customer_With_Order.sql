-- Create a full script with variables that allows you 
-- to add a new Customer into the database. Then create an order for them
-- that includes 5 products. Create 5 variables at the top of the script
-- that store the 5 product names the customer wants to buy. You will use
-- the product names to find the id

-- Requirements
/*
    I should be able to run the script on my machine without having to
    write any queries to look up the id's of any tables. (The only id that
    I should have to know is the new CustomerId - which is a 5 letter code 
    that we will choose )

    Use variables at the top of the script to collect User Input. The rest 
    of the script should run without hardcoding ANY values.

    I.E. if I want to add a new customer, and order, I should be able 
    to change the variables at the beginning of the script, and run the whole
    script.
*/

/*
Customer must include: 
    Customer Id: 5 letter code
    Company Name: (You can use chatgpt or https://businessnamegenerator.com to pick a name)
    Contact Name: (you can use chatgpt or http://random-name-generator.info to pick a name)
    Address
    City
    Region
    Postal Code
    Country

Order:
    Order id: auto generated
    Customer Id: id from the inserted customer
    Order Date: today's date
    Ship Name: Contact name
    Ship Address: The company address information

OrderDetails: (Create 5 line items)
    Order Id: the one created above
    Product Id: use the product names to select/find the id of each product
    Unit Price: use the default list price of each product
    Quantity: you decide - between 1-10
    Discount: 0
*/
-- CREATING USER ACCOUNT --

-- USER INPUT --
SET @customer_id = 'ABCDE' -- REQUIRED
	, @companyName = 'Gregors Meebers' -- REQUIRED
	, @contactName = 'Sophia Brown' -- OPTIONAL
    , @address = '123 Niantic Way' -- OPTIONAL
    , @city = 'Washington' -- OPTIONAL
    , @region = 'WA' -- OPTIONAL
    , @postalCode = 96734 -- OPTIONAL
    , @country = 'USA' -- OPTIONAL
    
	, @product1 = 'Rogede sild' -- NAME OF PRODUCT
	, @product2 = 'Chocolade' -- NAME OF PRODUCT
    , @product3 = 'Adjustable Dumbbells Set' -- NAME OF PRODUCT
    , @product4 = 'Durable Tennis Racket' -- NAME OF PRODUCT
    , @product5 = 'Louisiana Fiery Hot Pepper Sauce'; -- NAME OF PRODUCT
    
-- INSERT USER ACCOUNT --

INSERT customers (
	customer_id
	, company_name
	, contact_name
    , address
    , city
    , region
    , postal_code
    , country
)
VALUE (
	@customer_id
    , @companyName
    , @contactName
    , @address
    , @city
    , @region
    , @postalCode
    , @country
);

    
-- PLACE ORDER --

    
-- PLACING ORDER --
INSERT orders (
	customer_id
    , order_date
    , ship_name -- CONTACT NAME
    , ship_address
)
VALUE (
	@customer_id
    , NOW()
    , @contactName
    , @address
);


-- ORDERING THE 5 ITEMS -- 
SELECT * FROM products;

SET @orderId = (SELECT MAX(order_id) FROM orders);
    
INSERT order_details (
	order_id
    , product_id
    , unit_price
    , quantity
    , discount
) 
VALUE 
(
	@orderId
    , (SELECT product_id FROM products WHERE product_name = @product1)
    , (SELECT unit_price FROM products WHERE product_name = @product1)
    , FLOOR(RAND() * 10) + 1
    , 0
)
,(
    @orderId
    , (SELECT product_id FROM products WHERE product_name = @product2)
    , (SELECT unit_price FROM products WHERE product_name = @product2)
    , FLOOR(RAND() * 10) + 1
    , 0
)
,(
    @orderId
    , (SELECT product_id FROM products WHERE product_name = @product3)
    , (SELECT unit_price FROM products WHERE product_name = @product3)
    , FLOOR(RAND() * 10) + 1
    , 0
)
,(
    @orderId
    , (SELECT product_id FROM products WHERE product_name = @product4)
    , (SELECT unit_price FROM products WHERE product_name = @product4)
    , FLOOR(RAND() * 10) + 1
    , 0
)
,(
    @orderId
    , (SELECT product_id FROM products WHERE product_name = @product5)
    , (SELECT unit_price FROM products WHERE product_name = @product5)
    , FLOOR(RAND() * 10) + 1
    , 0
);

SELECT o.*, p.product_name FROM order_details o LEFT JOIN products p ON o.product_id = p.product_id WHERE o.order_id = @orderId;


