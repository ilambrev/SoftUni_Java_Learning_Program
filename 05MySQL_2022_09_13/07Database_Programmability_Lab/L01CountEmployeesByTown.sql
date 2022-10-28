USE `soft_uni`;

DELIMITER $$

CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(255))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE count INT;
    SET count := (SELECT COUNT(e.`employee_id`)
    FROM employees AS e
    INNER JOIN `addresses` AS a
    ON a.`address_id` = e.`address_id`
    INNER JOIN `towns` AS t
    ON t.`town_id` = a.`town_id`
    WHERE t.`name` = town_name
    );
	RETURN count;
END$$

SELECT ufn_count_employees_by_town('Sofia') AS `count`;