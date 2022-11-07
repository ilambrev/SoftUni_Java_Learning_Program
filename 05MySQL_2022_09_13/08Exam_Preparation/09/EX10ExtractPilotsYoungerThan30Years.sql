USE `cjms_db`;

SELECT s.`name`, s.`manufacturer`
FROM `spaceships` AS s
INNER JOIN `journeys` AS j
ON s.`id` = j.`spaceship_id`
INNER JOIN `travel_cards` AS tc
ON j.`id` = tc.`journey_id`
INNER JOIN `colonists` AS c
ON c.`id` = tc.`colonist_id`
WHERE TIMESTAMPDIFF(YEAR, c.`birth_date`, "2019-01-01") < 30 AND tc.`job_during_journey` = "Pilot"
ORDER BY s.`name`;