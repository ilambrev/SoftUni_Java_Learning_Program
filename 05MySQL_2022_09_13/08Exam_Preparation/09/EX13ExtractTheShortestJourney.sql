USE `cjms_db`;

SELECT j.`id`,
		p.`name` AS 'planet_name',
		s.`name` AS 'spaceport_name',
        j.`purpose` AS 'journey_purpose'
FROM `journeys` AS j
LEFT JOIN `spaceports` AS s
ON s.`id` = j.`destination_spaceport_id`
INNER JOIN `planets` AS p
ON p.`id` = s.`planet_id`
WHERE DATEDIFF(j.`journey_end`, j.`journey_start`) = (SELECT MIN(DATEDIFF(j1.`journey_end`, j1.`journey_start`)) FROM `journeys` AS j1);