USE `instd`;

SELECT p.`id`, p.`date` AS `date_and_time`, p.`description`, COUNT(c.`photo_id`) AS `commentsCount`
FROM `photos` AS p
LEFT JOIN `comments` AS c
ON p.`id` = c.`photo_id`
GROUP BY p.`id`
ORDER BY `commentsCount` DESC, p.`id`
LIMIT 5;