USE `cjms_db`;

SELECT COUNT(tc.`colonist_id`) AS 'count'
FROM `travel_cards` tc
INNER JOIN `journeys` AS j
ON j.`id` = tc.`journey_id`
WHERE j.`purpose` = "Technical";