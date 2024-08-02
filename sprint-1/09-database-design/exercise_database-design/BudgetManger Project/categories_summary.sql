# ---------------------------------------------------------------------- #
#                                 PURPOSE                                #
#        DISPLAYS A USERS TOTAL MONTHLY EXPENSES IN EACH CATEGORY        #
# ---------------------------------------------------------------------- #
# ---------------------------------------------------------------------- #
#                                 USER INPUT                             #
# ---------------------------------------------------------------------- #
USE financial;

SET @search_for_user = 'John Doe', -- INSERT FULL NAME
	@search_for_month = '09';         -- INSERT MONTH NUMBER ** ONLY AUGUST / SEPTEMBER SEEDED ** 

SELECT c.category_name AS Category
	, SUM(e.amount) AS Category_Total
FROM expenses e
JOIN sub_categories s
ON e.category_id = s.sub_category_id
JOIN categories c
ON c.category_id = s.parent_id
JOIN users u
ON u.user_id = e.user_id
WHERE u.full_name = @search_for_user AND DATE_FORMAT(e.date, '%m') = @search_for_month
GROUP BY c.category_name
ORDER BY Category DESC;

