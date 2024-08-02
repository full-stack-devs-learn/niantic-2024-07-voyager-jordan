# ---------------------------------------------------------------------- #
#                                 PURPOSE                                #
#      DISPLAYS ALL SUB-CATEGORIES BY PERSON/MONTH/PARENT CATEGORY       #
# ---------------------------------------------------------------------- #

# ---------------------------------------------------------------------- #
#                                 USER INPUT                             #
# ---------------------------------------------------------------------- #
USE financial;

SET @search_for_user = 'John Doe', -- INSERT FULL NAME
	@search_for_month = '08',      -- INSERT MONTH NUMBER ** ONLY AUGUST / SEPTEMBER SEEDED **
    @search_for_category = 'Vacation/Travel'; -- INSERT CATEGORY NAME
    
    
SELECT 
	c.category_name
	, s.sub_category_name
	, t.amount
    , t.date
    , t.note
FROM transactions t
JOIN sub_categories s ON t.category_id = s.sub_category_id
JOIN categories c ON c.category_id = s.parent_id
JOIN users u ON u.user_id = t.user_id
WHERE u.full_name = @search_for_user 
AND DATE_FORMAT(t.date, '%m') = @search_for_month 
AND c.category_name = @search_for_category
ORDER BY DATE;