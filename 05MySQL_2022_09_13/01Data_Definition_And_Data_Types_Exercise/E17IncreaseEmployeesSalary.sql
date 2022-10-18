USE `soft_uni`;

UPDATE `employees`
SET `salary` = `salary` + `salary` * 0.10;

SELECT `salary` from `employees`;