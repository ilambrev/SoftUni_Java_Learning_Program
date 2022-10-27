USE `soft_uni`;

SELECT
	e.`employee_id`,
	CONCAT_WS(" ", e.`first_name`, e.`last_name`) AS 'employee_name',
	CONCAT_WS(" ", e1.`first_name`, e1.`last_name`) AS 'manager_name', 
	d.`name` AS 'department_name'
FROM `employees` AS e, `employees` AS e1, `departments` AS d
WHERE e.`manager_id` = e1.`employee_id` AND e.`manager_id` IS NOT NULL AND e.`department_id` = d.`department_id`
ORDER BY e.`employee_id`
LIMIT 5;