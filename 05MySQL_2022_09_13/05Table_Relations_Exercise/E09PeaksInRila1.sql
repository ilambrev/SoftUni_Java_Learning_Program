USE `geography`;

SELECT `mountains`.`mountain_range`, `peaks`.`peak_name`, `peaks`.`elevation` AS `peak_elevation`
FROM `mountains`, `peaks`
WHERE `mountains`.`mountain_range` = "Rila" AND `mountains`.`id` = `peaks`.`mountain_id`
ORDER BY `peak_elevation` DESC;