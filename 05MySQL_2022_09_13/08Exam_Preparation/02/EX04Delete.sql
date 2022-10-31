USE `online_store`;

DELETE FROM `customers` AS c
WHERE c.`id` NOT IN (SELECT * FROM (SELECT DISTINCT(c1.`id`)
								FROM `customers` AS c1
								JOIN `orders` AS o
                                ON c1.`id` = o.`customer_id`) AS t);