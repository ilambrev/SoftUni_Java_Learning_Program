USE `soft_uni`;

SELECT `first_name`
FROM `employees`
WHERE `department_id` IN(3, 10)
AND YEAR(`hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;