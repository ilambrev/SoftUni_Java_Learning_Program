USE `soft_uni`;

UPDATE `employees`
SET `salary` = `salary` + 0.12 * `salary`
WHERE `department_id` IN (1, 2, 4, 11);

SELECT `salary` FROM `employees`;