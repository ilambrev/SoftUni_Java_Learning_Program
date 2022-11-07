USE `cjms_db`;

SELECT p.`name` AS 'planet_name', s.`name` AS 'spaceport_name'
FROM `planets` AS p
INNER JOIN `spaceports` AS s
ON p.`id` = s.`planet_id`
INNER JOIN `journeys` AS j
ON s.`id` = j.`destination_spaceport_id`
WHERE j.`purpose` = "Educational"
ORDER BY `spaceport_name` DESC;