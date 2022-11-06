USE `ruk_database`;

SELECT CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS 'name',
		e.`started_on`,
        COUNT(ec.`client_id`) AS 'count_of_clients'
FROM `employees` AS e
LEFT JOIN `employees_clients` As ec
ON e.`id` = ec.`employee_id`
GROUP BY e.`id`
ORDER BY `count_of_clients` DESC, e.`id`
LIMIT 5;