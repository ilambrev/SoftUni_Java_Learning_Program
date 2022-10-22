USE `restaurant`;

SELECT COUNT(`category_id`)
FROM `products`
WHERE `price` > 8 AND `category_id` = 2;