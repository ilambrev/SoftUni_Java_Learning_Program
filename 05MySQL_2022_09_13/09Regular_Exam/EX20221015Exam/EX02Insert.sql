USE `restaurant_db`;

INSERT INTO `products` (`name`, `type`, `price`)
SELECT CONCAT(`last_name`, ' ', "specialty"),
"Cocktail",
CEILING(`salary` * 0.01)
FROM `waiters`
WHERE `id` > 6;