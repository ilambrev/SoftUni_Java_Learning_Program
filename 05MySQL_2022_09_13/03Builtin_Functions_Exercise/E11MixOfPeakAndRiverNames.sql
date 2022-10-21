USE `geography`;

SELECT `peak_name`, `river_name`, CONCAT(LOWER(LEFT(`peak_name`, CHAR_LENGTH(`peak_name`) - 1)), LOWER(`river_name`)) AS `mix`
FROM `peaks`, `rivers`
WHERE RIGHT(`peak_name`, 1) = LEFT(`river_name`, 1) 
ORDER BY `mix`;