USE `restaurant`;

SELECT `category_id`,
ROUND(AVG(`price`), 2) AS `Average Price`,
ROUND(MIN(`price`), 2) AS `Cheapest Product`,
ROUND(MAX(`price`), 2) AS `Most Expensive Product`
FROM `products`
GROUP BY `category_id`;