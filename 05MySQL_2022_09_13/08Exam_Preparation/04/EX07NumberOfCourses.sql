USE `softuni_stc`;

SELECT c.`id` AS 'car_id',
c.`make`,
c.`mileage`,
COUNT(co.`id`) AS 'count_of_courses',
FORMAT(AVG(`bill`), 2) AS 'avg_bill'
FROM `cars` AS c
LEFT JOIN `courses` AS co
ON c.`id` = co.`car_id`
GROUP BY c.`id`
HAVING `count_of_courses` <> 2
ORDER BY `count_of_courses` DESC, c.`id`;