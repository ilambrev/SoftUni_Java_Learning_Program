USE `softuni_gdb`;

SELECT g.`name`,
IF(g.`budget` < 50000, "Normal budget", "Insufficient budget") AS 'budget_level',
t.`name` AS 'team_name',
a.`name` AS 'address_name'
FROM `games` AS g
INNER JOIN `teams` AS t
ON t.`id` = g.`team_id`
INNER JOIN `offices` AS o
ON o.`id` = t.`office_id`
INNER JOIN `addresses` AS a
ON a.`id` = o.`address_id`
WHERE g.`release_date` IS NULL AND g.`id` NOT IN (SELECT * FROM (SELECT `game_id` FROM `games_categories`) AS t)
ORDER BY g.`name`;