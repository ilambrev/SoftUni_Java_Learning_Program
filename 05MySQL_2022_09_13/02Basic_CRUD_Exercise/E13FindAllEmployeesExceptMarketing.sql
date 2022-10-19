USE `soft_uni`;

SELECT `first_name`, `last_name` FROM `employees`
WHERE `department_id` NOT IN (4);