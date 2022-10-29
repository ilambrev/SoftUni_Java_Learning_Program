USE `soft_uni`;

DELIMITER $$

CREATE FUNCTION ufn_get_salary_level(employee_salary DECIMAL(19, 4))
RETURNS VARCHAR(7)
DETERMINISTIC
BEGIN
	DECLARE salary_level VARCHAR(7);
	SET salary_level := (IF (employee_salary < 30000, "Low", (IF (employee_salary BETWEEN 30000 AND 50000, "Average", "High"))));
RETURN salary_level;
END$$

SELECT ufn_get_salary_level(13500.00) AS 'salary_Level';