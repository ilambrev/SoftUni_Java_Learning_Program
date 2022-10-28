USE `soft_uni`;

DELIMITER $$

CREATE PROCEDURE usp_raise_salary_by_id(id INT)

BEGIN
	UPDATE `employees`
    SET `salary` = `salary` * 1.05
    WHERE `employee_id` = id;
END$$

CALL usp_raise_salary_by_id(17);

SELECT `salary`
FROM `employees`
WHERE `employee_id` = 17;