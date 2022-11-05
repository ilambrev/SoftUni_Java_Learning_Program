USE `fsd`;

SELECT c.`name`, COUNT(p.`id`) AS `total_count_of_players`, SUM(p.`salary`) AS `total_sum_of_salaries`
FROM `countries` AS c
LEFT JOIN `towns` AS t
ON c.`id` = t.`country_id`
LEFT JOIN `stadiums` AS s
ON t.`id` = s.`town_id`
LEFT JOIN `teams` AS tm
ON s.`id` = tm.`stadium_id`
LEFT JOIN `players` AS p
ON tm.`id` = p.`team_id`
GROUP BY c.`id`
ORDER BY `total_count_of_players` DESC, c.`name`;