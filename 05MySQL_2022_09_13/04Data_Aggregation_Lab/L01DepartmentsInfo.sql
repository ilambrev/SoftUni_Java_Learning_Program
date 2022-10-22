USE `restaurant`;

SELECT `department_id`,
COUNT(*) AS `Number of employees`
FROM `employees` GROUP BY `department_id`
ORDER BY `department_id`;