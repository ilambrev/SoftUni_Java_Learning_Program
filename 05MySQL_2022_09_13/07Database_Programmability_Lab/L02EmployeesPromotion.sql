USE `soft_uni`;

DELIMITER $$

CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(50))
BEGIN
	UPDATE `employees`
    SET `salary` = `salary` * 1.05
    WHERE `department_id` = (SELECT `department_id`
		FROM `departments`
        WHERE `name` = department_name);
END$$

CALL usp_raise_salaries("Finance");

SELECT `first_name`, `salary`
FROM `employees`
WHERE `department_id` = 10
ORDER BY `first_name`, `salary`;