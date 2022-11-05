SELECT MAX(sk.`speed`) AS `max_speed`, t.`name`
FROM `towns` AS t
INNER JOIN `stadiums` AS s
ON t.`id` = s.`town_id`
INNER JOIN `teams` AS tm
ON s.`id` = tm.`stadium_id`
LEFT JOIN `players` AS p
ON tm.`id` = p.`team_id`
LEFT JOIN `skills_data` AS sk
ON sk.`id` = p.`skills_data_id`
WHERE t.`name` != "Devify"
GROUP BY t.`id`
ORDER BY `max_speed` DESC, t.`name`;