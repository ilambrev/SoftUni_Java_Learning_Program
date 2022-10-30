USE `softuni_imdb`;

SELECT c.`name`, COUNT(m.`id`) AS 'movies_count'
FROM `countries` AS c
LEFT JOIN `movies` AS m
ON c.`id` = m.`country_id`
GROUP BY c.`id`
HAVING `movies_count` >= 7
ORDER BY c.`name` DESC;