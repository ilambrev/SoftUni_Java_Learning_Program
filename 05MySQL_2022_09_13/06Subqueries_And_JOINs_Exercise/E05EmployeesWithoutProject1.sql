USE `soft_uni`;

SELECT e.`employee_id`, e.`first_name`
FROM employees AS e
LEFT JOIN `employees_projects` AS p
ON e.`employee_id` = p.`employee_id`
WHERE p.`project_id` IS NULL
ORDER BY e.`employee_id` DESC
LIMIT 3;