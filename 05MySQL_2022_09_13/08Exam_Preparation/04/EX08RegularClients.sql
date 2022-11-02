USE `softuni_stc`;

SELECT cl.`full_name`, COUNT(DISTINCT(c.`car_id`)) AS 'count_of_cars', SUM(c.`bill`) AS 'total_sum'
FROM `clients` AS cl
INNER JOIN `courses` AS c
ON cl.`id` = c.`client_id`
GROUP BY cl.`id`
HAVING cl.`full_name` LIKE ("_a%") AND `count_of_cars` > 1
ORDER BY cl.`full_name`;