USE `softuni_imdb`;

SELECT CONCAT_WS(' ', a.`first_name`, a.`last_name`) AS 'full_name',
	CONCAT(REVERSE(a.`last_name`), CHAR_LENGTH(a.`last_name`), "@cast.com") AS 'email',
    2022 - YEAR(a.`birthdate`) AS 'age',
    a.`height`
FROM `actors` AS a
WHERE a.`id` NOT IN (SELECT ma.`actor_id` FROM `movies_actors` AS ma)
ORDER BY `height`;