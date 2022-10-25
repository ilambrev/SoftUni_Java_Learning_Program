USE `geography`;

SELECT `mountains`.`mountain_range`, `peaks`.`peak_name`, `peaks`.`elevation` AS `peak_elevation`
FROM `mountains`
INNER JOIN `peaks`
ON `mountains`.`id` = `peaks`.`mountain_id`
WHERE `mountains`.`mountain_range` = "Rila"
ORDER BY `peak_elevation` DESC;