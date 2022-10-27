USE `soft_uni`;

SELECT e.`employee_id`, e.`first_name`, e.`manager_id`, e1.`first_name`
FROM `employees` AS e, `employees` AS e1
WHERE e.`employee_id` <> e1.`employee_id` AND e.`manager_id` = e1.`employee_id` AND e.`manager_id` IN (3, 7)
ORDER BY e.`first_name`;