USE `geography`;

SELECT `country_name`, `iso_code`
FROM `countries`
WHERE `country_name` LIKE('%A%A%A%')
ORDER BY `iso_code`;