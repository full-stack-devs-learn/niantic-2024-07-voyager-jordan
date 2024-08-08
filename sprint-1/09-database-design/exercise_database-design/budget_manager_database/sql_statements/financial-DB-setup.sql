# ---------------------------------------------------------------------- #
#           NOTE: ALL SAMPLE DATA WAS GENERATED FROM CHATGPT             #
# BY PROVIDING CATEGORIES LISTED IN THE READ-ME AND HAVING IT GENERATE   #
# COMPANIES THAT ARE ASSOCIATED WITH PARENT CATEGORIES                   #
# EXPENSES WERE GENERATED BY GIVING IT ALL USERS/VENDORS AND SUB CATEGORY#
# ASIDE FROM THOSE SCENARIOS EVERYTHING ELSE WAS CODED BY MYSELF         #
# ---------------------------------------------------------------------- #

DROP DATABASE IF EXISTS financial;
CREATE DATABASE IF NOT EXISTS financial;
USE financial;

# ---------------------------------------------------------------------- #
# CREATE TABLES                                                          #
# ---------------------------------------------------------------------- #
CREATE TABLE country (
    country_id INT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(100) NOT NULL,
    country_code CHAR(2) UNIQUE NOT NULL 
);

CREATE TABLE region (
    region_id INT AUTO_INCREMENT PRIMARY KEY,
    region_name VARCHAR(100) NOT NULL,
    country_id INT NOT NULL,
    FOREIGN KEY (country_id) REFERENCES country(country_id) ON DELETE CASCADE
);

CREATE TABLE city (
    city_id INT AUTO_INCREMENT PRIMARY KEY,
    city_name VARCHAR(100) NOT NULL,
    region_id INT NOT NULL,
    FOREIGN KEY (region_id) REFERENCES region(region_id) ON DELETE CASCADE
);

CREATE TABLE address (
    address_id INT AUTO_INCREMENT PRIMARY KEY,
    street_name VARCHAR(255) NOT NULL,
    city_id INT NOT NULL,
    postal_code VARCHAR(20),
    FOREIGN KEY (city_id) REFERENCES city(city_id) ON DELETE CASCADE
);

CREATE TABLE users
(
	user_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(25),
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    full_name VARCHAR(100) GENERATED ALWAYS AS (CONCAT(first_name, " ", last_name)) STORED,
    address_id INT NULL,
    PRIMARY KEY (user_id),
    FOREIGN KEY (address_id) REFERENCES address(address_id)
);

CREATE TABLE accounts
(
	account_id INT NOT NULL AUTO_INCREMENT,
    account_name VARCHAR(50) DEFAULT "Unnamed",
    account_balance DECIMAL(10, 2) DEFAULT 0.00,
    PRIMARY KEY (account_id)
);

CREATE TABLE useraccounts
(
	account_id INT NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (account_id, user_id),
    FOREIGN KEY (account_id) REFERENCES accounts(account_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE vendors 
(
	vendor_id INT NOT NULL AUTO_INCREMENT,
    vendor_name VARCHAR(50) NOT NULL,
    PRIMARY KEY(vendor_id)
);

CREATE TABLE categories
(
	category_id INT NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(50) NOT NULL,
    category_owner INT NULL,
    PRIMARY KEY(category_id)
);

CREATE TABLE subcategories
(
	subcategory_id INT NOT NULL AUTO_INCREMENT,
    subcategory_name VARCHAR(50) NOT NULL,
    parent_id INT NOT NULL,
    subcategory_owner INT NULL,
    PRIMARY KEY(subcategory_id),
    FOREIGN KEY(parent_id) REFERENCES categories(category_id),
    FOREIGN KEY (subcategory_owner) REFERENCES users(user_id)
);

CREATE TABLE userbudgets
(
    budget_id INT NOT NULL AUTO_INCREMENT,
    owner INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    budget_limit DECIMAL(10, 2) NULL,
    PRIMARY KEY (budget_id),
    FOREIGN KEY (owner) REFERENCES users(user_id)
);

CREATE TABLE transactions
(	
    transaction_id INT NOT NULL AUTO_INCREMENT,
    owner INT NOT NULL,
    budget_id INT NULL,
    vendor_id INT NOT NULL,
    subcategory_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    date DATE NOT NULL,
    note TINYTEXT,
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (vendor_id) REFERENCES vendors(vendor_id),
    FOREIGN KEY (subcategory_id) REFERENCES subcategories(subcategory_id),
    FOREIGN KEY (owner) REFERENCES users(user_id),
    FOREIGN KEY (budget_id) REFERENCES userBudgets(budget_id)
);

# ---------------------------------------------------------------------- #
# INSERT USERS DATA                                                      #
# ---------------------------------------------------------------------- #
INSERT users (first_name, last_name, email, password) VALUES
('John', 'Doe', "JohnDoe@gmail.com", "123password"),
('Sarah', 'Smith', "SarahSmith@gmail.com", "Password123");
# ---------------------------------------------------------------------- #
# INSERT VENDORS DATA                                                    #
# ---------------------------------------------------------------------- #
INSERT INTO vendors (vendor_name) VALUES
('TechGuru Electronics'),
('HomeEssentials Housing'),
('FunTimes Entertainment'),
('TravelMate Vacations'),
('GourmetDelight Food'),
('HealthPlus Healthcare'),
('SmartHome Appliances'),
('AdventureTravel Vacations'),
('FreshEats Groceries'),
('WellnessCare Health');
# ---------------------------------------------------------------------- #
# INSERT PARENT CATEGORIES DATA --- 6                                    #
# ---------------------------------------------------------------------- #
INSERT INTO categories (category_name) VALUES
('Entertainment'),
('Food'),
('Healthcare'),
('Housing'),
('Transportation'),
('Vacation/Travel');
# ---------------------------------------------------------------------- #
# INSERT SUB CATEGORIES DATA --- 5 x 6                                   #
# ---------------------------------------------------------------------- #
INSERT INTO subcategories (subcategory_name, parent_id) VALUES
-- Entertainment
('Movies', 1),
('Music', 1),
('Theater', 1),
('Video Games', 1),
('Concerts', 1),

-- Food
('Restaurants', 2),
('Cafes', 2),
('Fast Food', 2),
('Bakeries', 2),
('Food Trucks', 2),

-- Healthcare
('Hospitals', 3),
('Clinics', 3),
('Pharmacies', 3),
('Dental Care', 3),
('Optical Care', 3),

-- Housing
('Rentals', 4),
('Real Estate', 4),
('Property Management', 4),
('Home Improvement', 4),
('Storage Solutions', 4),

-- Transportation
('Public Transit', 5),
('Car Rentals', 5),
('Ride-Sharing', 5),
('Taxi Services', 5),
('Bicycles', 5),

-- Vacation/Travel
('Beach Resorts', 6),
('Mountain Retreats', 6),
('City Tours', 6),
('Cruises', 6),
('Adventure Trips', 6);
# ---------------------------------------------------------------------- #
# CREATE BUDGET FOR JOHN AND SARAH                                       #
# ---------------------------------------------------------------------- #
-- For John Doe (user_id = 1)
INSERT INTO userbudgets (owner, name, budget_limit) VALUES
(1, 'August Budget', 1000.00),
(1, 'September Budget', 1200.00);

-- For Sarah Smith (user_id = 2)
INSERT INTO userbudgets (owner, name, budget_limit) VALUES
(2, 'August Budget', 1000.00),
(2, 'September Budget', 1200.00);
# ---------------------------------------------------------------------- #
# INSERT TRANSACTIONS DATA                                               #
# ---------------------------------------------------------------------- #
INSERT INTO transactions (vendor_id, subcategory_id, owner, budget_id, amount, date, note) VALUES
-- JOHN DOE
(1, 7, 1, 1, 85.00, '2024-08-01', 'Purchased new tech gadgets for home.'),
(5, 15, 1, 1, 55.00, '2024-08-02', 'Lunch at a food truck.'),
(3, 12, 1, 1, 90.00, '2024-08-03', 'Concert tickets for a local band.'),
(8, 22, 1, 1, 220.00, '2024-08-04', 'Booked a beach resort vacation.'),
(5, 5, 1, 1, 120.00, '2024-08-05', 'Dinner at a gourmet restaurant.'),
(6, 18, 1, 1, 250.00, '2024-08-06', 'Medical expenses including consultation.'),
(7, 8, 1, 1, 90.00, '2024-08-07', 'Home appliance repair service.'),
(4, 20, 1, 1, 35.00, '2024-08-08', 'Travel booking fee for upcoming trip.'),
(9, 3, 1, 1, 45.00, '2024-08-09', 'Grocery shopping at the local market.'),
(6, 25, 1, 1, 85.00, '2024-08-10', 'Routine health check-up.'),
(1, 1, 1, 1, 105.00, '2024-08-11', 'Latest tech gadget purchase.'),
(2, 17, 1, 1, 70.00, '2024-08-12', 'New living room furniture.'),
(3, 14, 1, 1, 80.00, '2024-08-13', 'Tickets for a jazz concert.'),
(8, 26, 1, 1, 240.00, '2024-08-14', 'Mountain retreat vacation.'),
(5, 30, 1, 1, 140.00, '2024-08-15', 'Fine dining experience at a top restaurant.'),
(6, 11, 1, 1, 300.00, '2024-08-16', 'Healthcare services including check-up.'),
(7, 21, 1, 1, 95.00, '2024-08-17', 'Appliance replacement for kitchen.'),
(4, 4, 1, 1, 50.00, '2024-08-18', 'Flight booking for upcoming trip.'),
(9, 2, 1, 1, 65.00, '2024-08-19', 'Monthly grocery shopping.'),
(6, 27, 1, 1, 120.00, '2024-08-20', 'Eye exam and treatment.'),
(1, 8, 1, 2, 115.00, '2024-09-01', 'New electronics purchase.'),
(2, 23, 1, 2, 75.00, '2024-09-02', 'Living room furniture upgrade.'),
(3, 4, 1, 2, 85.00, '2024-09-03', 'Tickets for a concert.'),
(8, 19, 1, 2, 260.00, '2024-09-04', 'Vacation at a mountain retreat.'),
(5, 14, 1, 2, 150.00, '2024-09-05', 'Fine dining at an upscale restaurant.'),
(6, 30, 1, 2, 310.00, '2024-09-06', 'Healthcare expenses including follow-up.'),
(7, 9, 1, 2, 100.00, '2024-09-07', 'Replaced kitchen appliance.'),
(4, 16, 1, 2, 55.00, '2024-09-08', 'Flight reservation for travel.'),
(9, 6, 1, 2, 68.00, '2024-09-09', 'Monthly groceries purchase.'),
(6, 22, 1, 2, 130.00, '2024-09-10', 'Eye exam and vision treatment.'),
(1, 24, 1, 2, 120.00, '2024-09-11', 'New tech gadget acquisition.'),
(2, 28, 1, 2, 80.00, '2024-09-12', 'New living room furniture.'),
(3, 13, 1, 2, 95.00, '2024-09-13', 'Music festival tickets purchased.'),
(8, 25, 1, 2, 270.00, '2024-09-14', 'Travel and accommodation for vacation.'),
(5, 5, 1, 2, 160.00, '2024-09-15', 'Dinner at a gourmet restaurant.'),
(6, 7, 1, 2, 325.00, '2024-09-16', 'Healthcare follow-up and consultation.'),
(7, 2, 1, 2, 110.00, '2024-09-17', 'Replaced home appliance.'),
(4, 26, 1, 2, 60.00, '2024-09-18', 'Travel insurance for trip.'),
(9, 12, 1, 2, 75.00, '2024-09-19', 'Grocery shopping and supplies.'),
(10, 17, 1, 2, 130.00, '2024-09-20', 'Eye check-up and vision treatment.'),
-- SARAH SMITH
(1, 6, 2, 3, 95.00, '2024-08-01', 'New smartphone purchase.'),
(5, 11, 2, 3, 60.00, '2024-08-02', 'Lunch at a food truck.'),
(4, 15, 2, 3, 85.00, '2024-08-03', 'Theater tickets for a play.'),
(8, 20, 2, 3, 230.00, '2024-08-04', 'Booking a beach resort.'),
(5, 13, 2, 3, 130.00, '2024-08-05', 'Dinner at a gourmet restaurant.'),
(6, 30, 2, 3, 270.00, '2024-08-06', 'Health check-up and consultation.'),
(7, 24, 2, 3, 85.00, '2024-08-07', 'Repair service for home appliances.'),
(4, 3, 2, 3, 45.00, '2024-08-08', 'Travel fee for booking a trip.'),
(9, 18, 2, 3, 50.00, '2024-08-09', 'Grocery shopping at the market.'),
(6, 28, 2, 3, 90.00, '2024-08-10', 'Routine health examination.'),
(1, 7, 2, 3, 115.00, '2024-08-11', 'Latest electronics purchase.'),
(2, 14, 2, 3, 75.00, '2024-08-12', 'New furniture for the home.'),
(3, 8, 2, 3, 85.00, '2024-08-13', 'Tickets for a concert.'),
(8, 27, 2, 3, 260.00, '2024-08-14', 'Vacation at a mountain retreat.'),
(5, 5, 2, 3, 150.00, '2024-08-15', 'Fine dining at an upscale restaurant.'),
(6, 12, 2, 3, 310.00, '2024-08-16', 'Healthcare expenses including follow-up.'),
(7, 17, 2, 3, 100.00, '2024-08-17', 'Replaced kitchen appliance.'),
(4, 16, 2, 3, 55.00, '2024-08-18', 'Flight reservation for travel.'),
(9, 19, 2, 3, 75.00, '2024-08-19', 'Grocery shopping and supplies.'),
(10, 23, 2, 3, 140.00, '2024-08-20', 'Eye exam and vision treatment.'),
-- September
(1, 10, 2, 4, 125.00, '2024-09-01', 'New electronics acquisition.'),
(2, 22, 2, 4, 80.00, '2024-09-02', 'Upgraded living room furniture.'),
(3, 6, 2, 4, 95.00, '2024-09-03', 'Concert tickets.'),
(8, 26, 2, 4, 270.00, '2024-09-04', 'Mountain retreat vacation.'),
(5, 19, 2, 4, 160.00, '2024-09-05', 'Dinner at a gourmet restaurant.'),
(6, 9, 2, 4, 320.00, '2024-09-06', 'Healthcare expenses including follow-up.'),
(7, 24, 2, 4, 110.00, '2024-09-07', 'Replaced home appliance.'),
(4, 30, 2, 4, 60.00, '2024-09-08', 'Travel insurance for upcoming trip.'),
(9, 12, 2, 4, 70.00, '2024-09-09', 'Monthly grocery shopping.'),
(6, 14, 2, 4, 135.00, '2024-09-10', 'Eye exam and vision treatment.'),
(1, 8, 2, 4, 130.00, '2024-09-11', 'Electronics purchase.'),
(2, 23, 2, 4, 85.00, '2024-09-12', 'New furniture for home.'),
(3, 11, 2, 4, 100.00, '2024-09-13', 'Tickets for a music festival.'),
(8, 20, 2, 4, 280.00, '2024-09-14', 'Travel and accommodation for vacation.'),
(5, 5, 2, 4, 170.00, '2024-09-15', 'Dinner at a gourmet restaurant.'),
(6, 17, 2, 4, 330.00, '2024-09-16', 'Healthcare follow-up and consultation.'),
(7, 2, 2, 4, 120.00, '2024-09-17', 'Replaced home appliance.'),
(4, 25, 2, 4, 65.00, '2024-09-18', 'Travel insurance and booking fees.'),
(9, 13, 2, 4, 80.00, '2024-09-19', 'Grocery shopping and supplies.'),
(10, 24, 2, 4, 140.00, '2024-09-20', 'Eye check-up and vision treatment.');
# ---------------------------------------------------------------------- #
#                            CREATE VIEWS                                #
# ---------------------------------------------------------------------- #