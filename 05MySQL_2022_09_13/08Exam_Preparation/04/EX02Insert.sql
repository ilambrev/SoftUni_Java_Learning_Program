USE `softuni_stc`;

INSERT INTO `clients` (`full_name`, `phone_number`)
SELECT CONCAT_WS(' ', d.`first_name`, d.`last_name`) AS 'full_name', CONCAT("(088) 9999", d.`id` * 2)
FROM `drivers` AS d
WHERE `id` BETWEEN 10 AND 20;