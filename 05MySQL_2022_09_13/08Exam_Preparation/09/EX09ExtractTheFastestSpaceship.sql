USE `cjms_db`;

SELECT s1.`name` AS 'spaceship_name', sp.`name` AS 'spaceport_name'
FROM `spaceships` AS s1
INNER JOIN `journeys` AS j
ON s1.`id` = j.`spaceship_id`
INNER JOIN `spaceports` AS sp
ON sp.`id` = j.`destination_spaceport_id`
WHERE s1.`light_speed_rate` = 
(SELECT MAX(s2.`light_speed_rate`) FROM `spaceships` AS s2);