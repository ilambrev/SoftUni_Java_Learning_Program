USE `softuni_stores_system`;

SELECT p.`name`,
p.`price`,
p.`best_before`,
CONCAT(SUBSTRING(p.`description`, 1, 10), "...") AS 'short_description',
pic.`url`
FROM `products` AS p
INNER JOIN `pictures` AS pic
ON pic.`id` = p.`picture_id`
WHERE CHAR_LENGTH(p.`description`) > 100 AND YEAR(pic.`added_on`) < 2019 AND p.`price` > 20
ORDER BY p.`price` DESC;