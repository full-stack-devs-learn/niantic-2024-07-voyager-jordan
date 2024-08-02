# ---------------------------------------------------------------------- #
#                                 PURPOSE                                #
#      DISPLAYS ALL SUB-CATEGORIES BY PERSON/MONTH/PARENT CATEGORY       #
# ---------------------------------------------------------------------- #

# ---------------------------------------------------------------------- #
#                                 USER INPUT                             #
# ---------------------------------------------------------------------- #
USE financial;

SET @search_for_user = 'Sarah Smith', -- INSERT FULL NAME
	@search_for_month = '08',      -- INSERT MONTH NUMBER ** ONLY AUGUST / SEPTEMBER SEEDED **
    @search_for_category = 'Entertainment'; -- INSERT CATEGORY NAME
    
    
SELECT 
	c.category_name
	, s.sub_category_name
	, e.amount
    , e.date
    , e.note
FROM expenses e
JOIN sub_categories s ON e.category_id = s.sub_category_id
JOIN categories c ON c.category_id = s.parent_id
JOIN users u ON u.user_id = e.user_id
WHERE u.full_name = @search_for_user 
AND DATE_FORMAT(e.date, '%m') = @search_for_month 
AND c.category_name = @search_for_category
ORDER BY DATE;