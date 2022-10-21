USE `soft_uni`;

SELECT `first_name`, `last_name`
FROM `employees`
WHERE `first_name` LIKE("Sa%")
ORDER BY `employee_id`;