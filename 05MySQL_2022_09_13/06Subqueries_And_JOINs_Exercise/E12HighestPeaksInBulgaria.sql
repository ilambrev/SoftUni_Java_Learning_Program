USE `geography`;

SELECT c.`country_code`, `mountain_range`, `peak_name`, `elevation`
FROM `countries` AS c
INNER JOIN `mountains_countries` AS mc
ON c.`country_code` = mc.`country_code`
INNER JOIN `mountains` AS m
ON m.`id` = mc.`mountain_id`
INNER JOIN `peaks` AS p
ON p.`mountain_id` = m.`id`
WHERE c.`country_code` = "BG" AND `elevation` > 2835
ORDER BY `elevation` DESC;