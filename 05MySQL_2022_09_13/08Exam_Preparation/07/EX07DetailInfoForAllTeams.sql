USE `fsd`;

SELECT t.`name`, t.`established`, t.`fan_base`, COUNT(p.`id`) AS `players_count`
FROM `teams` AS t
LEFT JOIN `players` AS p
ON t.`id` = p.`team_id`
GROUP BY t.`id`
ORDER BY `players_count` DESC, t.`fan_base` DESC;