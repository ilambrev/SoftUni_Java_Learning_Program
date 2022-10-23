USE `soft_uni`;

SELECT COUNT(*) AS ``
FROM `employees`
WHERE `manager_id` IS NULL;