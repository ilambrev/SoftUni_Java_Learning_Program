USE `cjms_db`;

SELECT p.`name` AS 'planet_name', COUNT(j.`id`) AS 'journeys_count'
FROM `planets` AS p
INNER JOIN `spaceports` AS s
ON p.`id` = s.`planet_id`
INNER JOIN `journeys` AS j
ON s.`id` = j.`destination_spaceport_id`
GROUP BY p.`name`
ORDER BY `journeys_count` DESC, `planet_name`;