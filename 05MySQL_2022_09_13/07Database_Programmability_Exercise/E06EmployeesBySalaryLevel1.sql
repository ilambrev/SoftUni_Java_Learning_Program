USE `soft_uni`;

DELIMITER $$

CREATE PROCEDURE usp_get_employees_by_salary_level(level_of_salary VARCHAR(7))

BEGIN
	
    SELECT `first_name`, `last_name`
    FROM `employees`
    WHERE ufn_get_salary_level(`salary`) = level_of_salary
    ORDER BY `first_name` DESC, `last_name` DESC;
    
END$$

CALL usp_get_employees_by_salary_level("high");