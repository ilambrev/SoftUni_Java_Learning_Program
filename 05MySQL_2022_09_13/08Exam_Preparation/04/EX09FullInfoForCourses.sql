USE `softuni_stc`;

SELECT a.`name`,
	CASE
		WHEN HOUR(c.`start`) BETWEEN 6 AND 20 THEN "Day"
        ELSE "Night"
	END AS `day_time`,
	c.`bill`,
	cl.`full_name`,
    ca.`make`,
    ca.`model`,
    cat.`name` AS `category_name`
FROM `addresses` AS a
INNER JOIN `courses` AS c
ON a.`id` = c.`from_address_id`
INNER JOIN `clients` AS cl
ON cl.`id` = c.`client_id`
INNER JOIN `cars` AS ca
ON ca.`id` = c.`car_id`
INNER JOIN `categories` AS cat
ON cat.`id` = ca.`category_id`
ORDER BY c.`id`;