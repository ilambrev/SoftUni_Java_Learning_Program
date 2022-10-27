USE `soft_uni`;

SELECT e.`employee_id`, e.`first_name`
FROM employees AS e
WHERE e.`employee_id` NOT IN (SELECT p.`employee_id` FROM `employees_projects` AS p)
ORDER BY e.`employee_id` DESC
LIMIT 3;