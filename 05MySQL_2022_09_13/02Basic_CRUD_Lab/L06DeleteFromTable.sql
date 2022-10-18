USE `hotel`;

DELETE FROM `employees`
WHERE `department_id` = 1 OR `department_id` = 2;

SELECT * FROM `employees`
ORDER BY `id`;