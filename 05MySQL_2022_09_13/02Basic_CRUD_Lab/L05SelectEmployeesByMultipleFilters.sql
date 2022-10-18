USE `hotel`;

SELECT * FROM `employees`
WHERE `department_id` = 4 AND `salary` >= 1000.00
ORDER BY `id`;