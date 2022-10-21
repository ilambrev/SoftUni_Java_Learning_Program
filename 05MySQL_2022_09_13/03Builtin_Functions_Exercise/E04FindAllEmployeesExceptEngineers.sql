USE `soft_uni`;

SELECT `first_name`, `last_name`
FROM `employees`
WHERE `job_title` NOT LIKE("%engineer%")
ORDER BY `employee_id`;