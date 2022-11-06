USE `ruk_database`;

UPDATE `employees_clients`
SET `employee_id` = (SELECT t.`employee_id` FROM (SELECT ec1.`employee_id`, COUNT(ec1.`client_id`) AS 'count'
						FROM `employees_clients` AS ec1
						GROUP BY ec1.`employee_id`
						ORDER BY `count`, ec1.`employee_id`
						LIMIT 1) AS t)
WHERE `client_id` IN (SELECT * FROM (SELECT ec2.`client_id`
					FROM `employees_clients` AS ec2
					WHERE ec2.`employee_id` = ec2.`client_id`) AS t)
AND `client_id` = `employee_id`;