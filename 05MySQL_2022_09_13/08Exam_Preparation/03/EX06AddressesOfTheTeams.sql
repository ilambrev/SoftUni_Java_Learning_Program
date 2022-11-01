USE `softuni_gdb`;

SELECT t.`name` AS `team_name`,
a.`name` AS `address_name`,
CHAR_LENGTH(a.`name`) AS 'count_of_characters'
FROM `teams` AS t
INNER JOIN `offices` AS o
ON t.`office_id` = o.`id`
INNER JOIN `addresses` AS a
ON o.`address_id` = a.`id`
WHERE o.`website` IS NOT NULL
ORDER BY `team_name`, `address_name`;