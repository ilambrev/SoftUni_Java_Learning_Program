USE `restaurant_db`;

SELECT CONCAT(`last_name`, `first_name`, CHAR_LENGTH(`first_name`), "Restaurant") AS 'username',
	REVERSE(SUBSTRING(`email`, 2, 12)) AS `password`
FROM `waiters`
WHERE `salary` IS NOT NULL
ORDER BY `password` DESC;