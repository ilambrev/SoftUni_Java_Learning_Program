USE `geography`;

SELECT c.`country_name`, t1.`max_elevation` AS `highest_peak_elevation`, t2.`max_length` AS `longest_river_length`
FROM `countries` AS c
LEFT JOIN (SELECT c1.`country_code`, MAX(p.`elevation`) AS `max_elevation`
	FROM `countries` AS c1
	LEFT JOIN `mountains_countries` AS mc
	ON c1.`country_code` = mc.`country_code`
	LEFT JOIN `peaks` AS p
	ON p.`mountain_id` = mc.`mountain_id`
	GROUP BY c1.`country_code`) AS t1
ON c.`country_code` = t1.`country_code`
LEFT JOIN (SELECT c2.`country_code`, MAX(r.`length`) AS `max_length`
	FROM `countries` AS c2
	LEFT JOIN `countries_rivers` AS cr
	ON c2.`country_code` = cr.`country_code`
	LEFT JOIN `rivers` AS r
	ON r.`id` = cr.`river_id`
	GROUP BY c2.`country_code`) AS t2
ON c.`country_code` = t2.`country_code`
ORDER BY `highest_peak_elevation` DESC, `longest_river_length` DESC, c.`country_name`
LIMIT 5;