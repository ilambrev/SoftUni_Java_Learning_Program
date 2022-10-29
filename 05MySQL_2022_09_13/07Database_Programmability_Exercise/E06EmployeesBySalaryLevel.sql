USE `soft_uni`;

DELIMITER $$

CREATE FUNCTION ufn_get_salary_level(employee_salary DECIMAL(19, 4))
RETURNS VARCHAR(7)
DETERMINISTIC
BEGIN
	DECLARE salary_level VARCHAR(7);
	IF employee_salary < 30000 THEN SET salary_level := "Low";
    ELSEIF employee_salary <= 50000 THEN SET salary_level := "Average";
	ELSE SET salary_level := "High";
    END IF;
RETURN salary_level;
END$$

CREATE PROCEDURE usp_get_employees_by_salary_level(level_of_salary VARCHAR(7))

BEGIN
	
    SELECT `first_name`, `last_name`
    FROM `employees`
    WHERE ufn_get_salary_level(`salary`) = level_of_salary
    ORDER BY `first_name` DESC, `last_name` DESC;
    
END$$

CALL usp_get_employees_by_salary_level("high");