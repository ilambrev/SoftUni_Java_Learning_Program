USE `softuni_gdb`;

UPDATE `employees` AS e
RIGHT JOIN `teams` AS t
ON e.`id` = t.`leader_id`
SET e.`salary` = e.`salary` + 1000
WHERE e.`age` < 40 AND e.`salary` < 5000;