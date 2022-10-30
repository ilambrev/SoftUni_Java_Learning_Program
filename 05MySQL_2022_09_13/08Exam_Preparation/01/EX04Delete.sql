USE `softuni_imdb`;

DELETE `countries`, `movies` FROM `countries`
LEFT JOIN `movies`
ON `countries`.`id` = `movies`.`country_id`
WHERE `movies`.`country_id` IS NULL;