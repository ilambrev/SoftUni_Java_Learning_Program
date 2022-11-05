USE `fsd`;

UPDATE `coaches` AS c1
INNER JOIN (SELECT c.`id`, COUNT(p.`id`) 
FROM `coaches` AS c
RIGHT JOIN `players_coaches` AS pc
ON c.`id` = pc.`coach_id`
INNER JOIN `players` AS p
ON p.`id` = pc.`player_id`
WHERE LEFT(c.`first_name`, 1) = "A"
GROUP BY c.`id`) AS s
ON c1.`id` = s.`id`
SET c1.`coach_level` = c1.`coach_level` + 1;