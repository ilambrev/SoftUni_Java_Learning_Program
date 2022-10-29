USE `soft_uni`;

DELIMITER $$

CREATE FUNCTION ufn_get_salary_level1(employee_salary DECIMAL(19, 4))
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

SELECT ufn_get_salary_level1(13500.00) AS 'salary_Level';