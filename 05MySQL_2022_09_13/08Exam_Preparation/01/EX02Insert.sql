USE `softuni_imdb`;

INSERT INTO `actors` (`first_name`, `last_name`, `birthdate`, `height`, `awards`, `country_id`)
SELECT REVERSE(`first_name`), REVERSE(`last_name`), DATE_SUB(`birthdate`, INTERVAL 2 DAY), `height` + 10, `country_id`, "3"
FROM `actors`
WHERE `id` <= 10;