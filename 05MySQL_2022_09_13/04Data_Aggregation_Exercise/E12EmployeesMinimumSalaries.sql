USE `soft_uni`;

SELECT `department_id`, MIN(`salary`) AS `minimum_salary`
FROM `employees`
WHERE `department_id` IN (2, 5, 7) AND `hire_date` > "2000_01_01 00:00:00 000000"
GROUP BY `department_id`
ORDER BY `department_id`;