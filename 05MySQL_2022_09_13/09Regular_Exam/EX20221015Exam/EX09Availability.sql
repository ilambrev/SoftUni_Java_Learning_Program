USE `restaurant_db`;

SELECT t.`id` AS 'table_id',
	t.`capacity`,
	COUNT(oc.`client_id`) AS 'count_clients',
	CASE
		WHEN t.`capacity` > COUNT(oc.`client_id`) THEN "Free seats"
		WHEN t.`capacity` = COUNT(oc.`client_id`) THEN "Full"
		ELSE "Extra seats"
	END AS 'availability'
FROM `tables` AS t
LEFT JOIN `orders` AS o
ON t.`id` = o.`table_id`
INNER JOIN `orders_clients` AS oc
ON o.`id` = oc.`order_id`
WHERE t.`floor` = 1
GROUP BY t.`id`
ORDER BY t.`id` DESC;