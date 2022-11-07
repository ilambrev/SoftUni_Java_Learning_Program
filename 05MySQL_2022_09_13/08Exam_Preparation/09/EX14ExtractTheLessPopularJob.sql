USE `cjms_db`;

SELECT tc.`job_during_journey`
FROM `travel_cards` AS tc
WHERE tc.`journey_id` = 7
GROUP BY tc.`job_during_journey`
HAVING COUNT(tc.`id`) = (SELECT MIN(t1.`count`) FROM (SELECT COUNT(tc1.`id`) AS 'count' FROM `travel_cards` AS tc1 
WHERE tc1.`journey_id` = (SELECT j.`id`
FROM `journeys` AS j
LEFT JOIN `spaceports` AS s
ON s.`id` = j.`destination_spaceport_id`
INNER JOIN `planets` AS p
ON p.`id` = s.`planet_id`
WHERE DATEDIFF(j.`journey_end`, j.`journey_start`) = (SELECT MAX(DATEDIFF(j1.`journey_end`, j1.`journey_start`)) FROM `journeys` AS j1))
GROUP BY `job_during_journey`) AS t1);