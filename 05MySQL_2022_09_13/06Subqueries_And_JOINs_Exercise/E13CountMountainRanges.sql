USE `geography`;

SELECT c.`country_code`, COUNT(`mountain_range`) AS `mountain_range`
FROM `countries` AS c
INNER JOIN `mountains_countries` AS mc
ON c.`country_code` = mc.`country_code`
INNER JOIN `mountains` AS m
ON m.`id` = mc.`mountain_id`
GROUP BY `country_code`
HAVING `country_code` IN ("BG", "RU", "US")
ORDER BY `mountain_range` DESC;