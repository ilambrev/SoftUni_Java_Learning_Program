USE `softuni_stores_system`;

DELETE FROM `employees` AS e
WHERE e.`salary` >= 6000
AND e.`manager_id`
AND e.`id` NOT IN (SELECT * FROM (SELECT DISTINCT(e1.`manager_id`) FROM `employees` AS e1 WHERE e1.`manager_id`) t);