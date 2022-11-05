USE `fsd`;

UPDATE `coaches` AS c
INNER JOIN `players_coaches` AS pc
ON c.`id` = pc.`coach_id`
SET c.`coach_level` = c.`coach_level` + 1
WHERE LEFT(c.`first_name`, 1) = "A";