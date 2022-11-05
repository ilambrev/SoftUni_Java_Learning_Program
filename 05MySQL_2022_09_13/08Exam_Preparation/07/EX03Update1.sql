USE `fsd`;

UPDATE `coaches` AS c
SET c.`coach_level` = c.`coach_level` + 1
WHERE c.`id` IN (
SELECT `coach_id`
FROM `players_coaches`)
AND c.`first_name` LIKE "A%";