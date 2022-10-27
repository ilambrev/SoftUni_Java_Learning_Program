USE `geography`;

SELECT COUNT(*) AS `country_count`
FROM (
SELECT c.`country_code`, mc.`mountain_id`
FROM `countries` AS c
LEFT JOIN `mountains_countries` AS mc
ON c.`country_code` = mc.`country_code`) AS t1
WHERE t1.`mountain_id` IS NULL;