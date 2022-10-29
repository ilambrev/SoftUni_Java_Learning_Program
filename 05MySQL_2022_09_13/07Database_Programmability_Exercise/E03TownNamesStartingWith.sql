USE `soft_uni`;

DELIMITER $$

CREATE PROCEDURE usp_get_towns_starting_with(part_of_name VARCHAR(50))

BEGIN
	SELECT `name` AS `town_name`
    FROM `towns`
    WHERE `name` LIKE CONCAT(part_of_name, "%")
    ORDER BY `name`;
END$$

CALL usp_get_towns_starting_with("b")